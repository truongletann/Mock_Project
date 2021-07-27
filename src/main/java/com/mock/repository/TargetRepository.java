package com.mock.repository;

import com.mock.dto.TargetDTO;
import com.mock.entity.Target;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface TargetRepository  extends JpaRepository<Target, Integer> {

    @Query("SELECT new com.mock.dto.TargetDTO(target_id,target_title,course_id)" +
            "FROM Target WHERE course_id =?1")
    List<TargetDTO> getTargetByCourses(int courseID);

    @Modifying
    @Query("UPDATE Target set target_title = ?1 " +
            " WHERE target_id =?2")
    void editTarget(String title, int targetID);
}
