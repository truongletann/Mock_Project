package com.mock.controller.admin;

import com.mock.dto.CourseCategoryDTO;
import com.mock.dto.CourseDTO;
import com.mock.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin/course")
public class AdminCourseController {

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
    public Object get(@PathVariable int id) {
        try {
            CourseDTO courseDTO = courseService.getById(id);
            return new ResponseEntity<Object>(courseDTO, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("")
    public Object post(@Valid @RequestBody CourseDTO courseDTO) {
        try {
            courseService.save(courseDTO);
            return new ResponseEntity<Object>(HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @PutMapping("")
    public Object put(@Valid @RequestBody CourseDTO courseDTO) {
        try {
            courseService.edit(courseDTO);
            return new ResponseEntity<Object>(HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @DeleteMapping("{id}")
    public Object delete(@PathVariable int id) {
        try {
            courseService.deleteById(id);
            return new ResponseEntity<Object>(HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }
}



