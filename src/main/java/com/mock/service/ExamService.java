package com.mock.service;

import com.mock.dto.ExamDTO;
import com.mock.dto.QuestionDTO;

import java.util.List;

public interface ExamService {

    List<ExamDTO> getExamByCourseUser(int courseID, int userID);

    void save(ExamDTO examDTO);
}
