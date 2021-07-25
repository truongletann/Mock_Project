package com.mock.controller.admin;

import com.mock.dto.AnswerDTO;
import com.mock.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/answer")
public class AdminAnsController {

    @Autowired
    private AnswerService answerService;

    @GetMapping("{id}")
    public Object get(@PathVariable int id) {
        try {
            List<AnswerDTO> answerDTO = answerService.getAnsByID(id);
            return new ResponseEntity<Object>(answerDTO, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @DeleteMapping("{id}")
    public Object delete(@PathVariable int id) {
        try {
            answerService.deleteById(id);
            return new ResponseEntity<Object>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

}
