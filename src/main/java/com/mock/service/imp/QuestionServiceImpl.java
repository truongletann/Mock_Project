package com.mock.service.imp;

import com.mock.dto.AnswerDTO;
import com.mock.dto.QuestionDTO;
import com.mock.entity.Answer;
import com.mock.entity.Question;
import com.mock.repository.AnswerRepository;
import com.mock.repository.QuestionRepository;
import com.mock.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
    private AnswerRepository answerRepository;



    @Override
    public List<QuestionDTO> getQuestionByID(int id) {
        return questionRepository.getQuestionDetailByID(id);
    }

    @Override
    public void save(QuestionDTO questionDTO) {
        if(questionDTO == null){
            return;
        }
        Question question = new Question(
                questionDTO.getQuestion_id(),
                questionDTO.getQuestion_content(),
                questionDTO.getCourse_id());
        questionRepository.save(question);
        for(AnswerDTO entity : questionDTO.getListAns()){
            answerRepository.save(new Answer(
                    entity.getAns_id(),
                    entity.getAns_content(),
                    entity.isIs_right(),
                    questionRepository.findAll().size()));
        }
    }

    @Override
    public void edit(QuestionDTO questionDTO) {
        if(questionDTO == null){
            return;
        }
        Question question = new Question(
                questionDTO.getQuestion_id(),
                questionDTO.getQuestion_content(),
                questionDTO.getCourse_id());
        questionRepository.saveAndFlush(question);
        for(AnswerDTO entity : questionDTO.getListAns()){
            answerRepository.saveAndFlush(new Answer(
                    entity.getAns_id(),
                    entity.getAns_content(),
                    entity.isIs_right(),
                    entity.getQuestion_id()));
        }

    }

    @Override
    public void deleteById(int id) {
        if(id < 0){
            return;
        }
        questionRepository.deleteById(id);
    }
}
