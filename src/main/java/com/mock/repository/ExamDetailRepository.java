package com.mock.repository;

import com.mock.dto.AnswerDTO;
import com.mock.dto.ExamDetailDTO;
import com.mock.entity.ExamDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamDetailRepository extends JpaRepository<ExamDetail, Integer> {

    @Query("FROM ExamDetail WHERE exam_id =?1")
    List<ExamDetail> getExamDetailByID(int examID);
}
