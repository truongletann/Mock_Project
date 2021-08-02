package com.mock.controller.user;

import com.mock.dto.ExamDetailDTO;
import com.mock.service.ExamDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/exam-detail")
public class UserExamDetailController {

    @Autowired
    private ExamDetailService examDetailService;

    @GetMapping("{id}")
    public Object get(@PathVariable int id) {
        try {
            List<ExamDetailDTO> examDetailDTO = examDetailService.getByExamID(id);
            return new ResponseEntity<Object>(examDetailDTO, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }
}
