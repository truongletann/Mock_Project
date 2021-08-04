package com.mock.controller.user;

import com.mock.dto.ExamDTO;
import com.mock.dto.UserEnrollDTO;
import com.mock.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/userau/exam")
public class UserExamController {

    @Autowired
    private ExamService examService;

    @GetMapping("/check/{courseID}/{userID}")
    public Object check(@PathVariable int courseID, @PathVariable int userID) {
        try {
            List<ExamDTO> examDTO = examService.getExamByCourseUser(courseID,userID);
            return new ResponseEntity<Object>(examDTO, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("")
    public Object post(@Valid @RequestBody ExamDTO examDTO) {
        try {
            examService.save(examDTO);
            return new ResponseEntity<Object>(HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }
}
