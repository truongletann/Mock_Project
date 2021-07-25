package com.mock.repository;

import com.mock.dto.AnswerDTO;
import com.mock.dto.CourseDetailDTO;
import com.mock.dto.QuestionDTO;
import com.mock.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

    @Query("SELECT new com.mock.dto.AnswerDTO(ans_id,ans_content,is_right,question_id)" +
            "FROM Answer WHERE question_id =?1")
    List<AnswerDTO> getAnsDetailByID(int quizID);

    @Query("DELETE FROM Answer WHERE question_id =?1")
    void deleteAns(int questionID);
}
