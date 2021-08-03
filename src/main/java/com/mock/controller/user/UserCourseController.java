package com.mock.controller.user;

import com.mock.dto.CourseDTO;
import com.mock.dto.UserEnrollDTO;
import com.mock.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/course")
public class UserCourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public Object get() {
        try {
            List<CourseDTO> listCourse = courseService.getAll();
            return new ResponseEntity<Object>(listCourse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("{id}")
    public Object getByID(@PathVariable int id) {
        try {
            CourseDTO courseDTO = courseService.getById(id);
            return new ResponseEntity<Object>(courseDTO, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/by-name/{name}")
    public Object get(@PathVariable String name) {
        try {
            List<CourseDTO> courseDTO = courseService.getByName(name);
            return new ResponseEntity<Object>(courseDTO, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("by-category/{categoryID}")
    public Object get(@PathVariable int categoryID) {
        try {
            List<CourseDTO> courseDTO = courseService.getByCategory(categoryID);
            return new ResponseEntity<Object>(courseDTO, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }
}
