package com.mock.repository;

import com.mock.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query("FROM Course WHERE title like %?1%")
    List<Course> getCourseByName(String name);

    @Query("FROM Course WHERE category_id = ?1")
    List<Course> getCourseByCategory(int categoryID);
}
