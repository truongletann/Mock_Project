package com.mock.controller.user;

import com.mock.dto.QuestionDTO;
import com.mock.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/question")
public class UserQuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("{id}")
    public Object get(@PathVariable int id) {
        try {
            List<QuestionDTO> questionDTO = questionService.questionExam(id);
            return new ResponseEntity<Object>(questionDTO, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }
}
