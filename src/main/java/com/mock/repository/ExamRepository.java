package com.mock.repository;

import com.mock.entity.Exam;
import com.mock.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {

    @Query("FROM Exam WHERE course_id =?1 and user_id=?2")
    List<Exam> getExamByCourseUser(int courseID, int userID);

    @Query("SELECT MAX(exam_id) FROM Exam ")
    int getIDEnd ();

}
