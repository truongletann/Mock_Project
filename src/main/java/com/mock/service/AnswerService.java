package com.mock.service;

import com.mock.dto.AnswerDTO;
import com.mock.dto.QuestionDTO;

import java.util.List;

public interface AnswerService {

    List<AnswerDTO> getAnsByID(int id);

    void deleteById(int id);
}
