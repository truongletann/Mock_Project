package com.mock.controller.user;

import com.mock.dto.UserEnrollDTO;
import com.mock.service.UserEnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/userau/userEnroll")
public class UserEnrollController {

    @Autowired
    private UserEnrollService userEnrollService;

    @GetMapping("{id}")
    public Object get(@PathVariable int id) {
        try {
            List<UserEnrollDTO> userEnrollDTO = userEnrollService.getById(id);
            return new ResponseEntity<Object>(userEnrollDTO, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/check/{userID}/{courseID}")
    public Object check(@PathVariable int userID, @PathVariable int courseID) {
        try {
            List<UserEnrollDTO> userEnrollDTOs = userEnrollService.getByUserCourse(userID,courseID);
            return new ResponseEntity<Object>(userEnrollDTOs, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("")
    public Object post(@Valid @RequestBody UserEnrollDTO userEnrollDTO) {
        try {
            userEnrollService.save(userEnrollDTO);
            return new ResponseEntity<Object>(HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }
}
