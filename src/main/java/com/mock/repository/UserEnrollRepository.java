package com.mock.repository;

import com.mock.entity.Question;
import com.mock.entity.UserEnroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserEnrollRepository extends JpaRepository<UserEnroll, Integer> {

    @Query("FROM UserEnroll WHERE user_id =?1")
    List<UserEnroll> getUserEnrollByID(int userID);

    @Query("FROM UserEnroll WHERE user_id =?1 and course_id=?2")
    List<UserEnroll> checkButton(int userID,int courseID);
}
