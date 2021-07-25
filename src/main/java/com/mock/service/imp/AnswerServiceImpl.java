package com.mock.service.imp;

import com.mock.dto.AnswerDTO;
import com.mock.repository.AnswerRepository;
import com.mock.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public List<AnswerDTO> getAnsByID(int id) {
        return answerRepository.getAnsDetailByID(id);
    }

    @Override
    public void deleteById(int id) {
        if(id < 0){
            return;
        }
        answerRepository.deleteById(id);
    }
}
