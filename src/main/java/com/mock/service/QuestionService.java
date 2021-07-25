package com.mock.service;

import com.mock.dto.QuestionDTO;
import com.mock.dto.TargetDTO;

import java.util.List;

public interface QuestionService {

    List<QuestionDTO> getQuestionByID(int id);

    void save(QuestionDTO questionDTO);

    void edit(QuestionDTO questionDTO);

    void deleteById(int id);
}
