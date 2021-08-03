package com.mock.repository;

import com.mock.dto.TargetDTO;
import com.mock.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Modifying
    @Query("UPDATE User set status = 0 " +
            " WHERE user_id =?1")
    void deleteUser(int userID);

    @Modifying
    @Query("UPDATE User set status = 1 " +
            " WHERE user_id =?1")
    void activeUser(int userID);

    @Query("SELECT u FROM User u WHERE u.email = :email and u.status = true")
    public User findByEmail(@Param("email") String email);

    @Query("select r.role_name from User u join Role r on u.role_id = r.role_id where u.user_id =?1")
    String getRoleName(int userID);
}
