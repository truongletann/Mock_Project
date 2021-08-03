package com.mock.controller.user;

import com.mock.dto.TargetDTO;
import com.mock.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/target")
public class UserTargetController {

    @Autowired
    private TargetService targetService;

    @GetMapping("by-course/{id}")
    public Object getByCourse(@PathVariable int id) {
        try {
            List<TargetDTO> targetDTO = targetService.getTargetByID(id);
            return new ResponseEntity<Object>(targetDTO, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }
}
