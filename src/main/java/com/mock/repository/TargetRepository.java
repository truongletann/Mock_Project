package com.mock.repository;

import com.mock.dto.TargetDTO;
import com.mock.entity.Target;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TargetRepository  extends JpaRepository<Target, Integer> {

    @Query("SELECT new com.mock.dto.TargetDTO(target_id,target_title,course_id)" +
            "FROM Target WHERE target_id =?1")
    List<TargetDTO> getTargetByCourses(int courseID);
}
