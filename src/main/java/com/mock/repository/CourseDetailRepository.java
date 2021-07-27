package com.mock.repository;

import com.mock.dto.CourseDetailDTO;
import com.mock.dto.TargetDTO;
import com.mock.entity.CourseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDetailRepository extends JpaRepository<CourseDetail, Integer> {
    @Query("SELECT new com.mock.dto.CourseDetailDTO(course_detail_id,title,url,course_id)" +
            "FROM CourseDetail WHERE course_id =?1")
    List<CourseDetailDTO> getCoursesDetailByID(int courseID);


}
