package com.mock.repository;

import com.mock.dto.CourseDetailDTO;
import com.mock.dto.QuestionDTO;
import com.mock.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Query("FROM Question WHERE course_id =?1")
    List<Question> getQuestionDetailByID(int courseID);


}
