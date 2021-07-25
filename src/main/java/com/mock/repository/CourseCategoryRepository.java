package com.mock.repository;

import com.mock.dto.TargetDTO;
import com.mock.entity.CourseCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseCategoryRepository extends JpaRepository<CourseCategory, Integer> {
}
