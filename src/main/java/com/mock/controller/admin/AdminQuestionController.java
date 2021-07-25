package com.mock.controller.admin;

import com.mock.dto.QuestionDTO;
import com.mock.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin/question")
public class AdminQuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("{id}")
    public Object get(@PathVariable int id) {
        try {
            List<QuestionDTO> questionDTO = questionService.getQuestionByID(id);
            return new ResponseEntity<Object>(questionDTO, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("")
    public Object post(@Valid @RequestBody QuestionDTO questionDTO) {
        try {
            questionService.save(questionDTO);
            return new ResponseEntity<Object>(HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @PutMapping("")
    public Object put(@Valid @RequestBody QuestionDTO questionDTO) {
        try {
            questionService.edit(questionDTO);
            return new ResponseEntity<Object>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @DeleteMapping("{id}")
    public Object delete(@PathVariable int id) {
        try {
            questionService.deleteById(id);
            return new ResponseEntity<Object>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }
}
