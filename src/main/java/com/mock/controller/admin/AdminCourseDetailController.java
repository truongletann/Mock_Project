package com.mock.controller.admin;

import com.mock.dto.CourseDetailDTO;
import com.mock.dto.TargetDTO;
import com.mock.service.CourseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin/course-detail")
public class AdminCourseDetailController {

    @Autowired
    private CourseDetailService courseDetailService;

    @GetMapping("{id}")
    public Object get(@PathVariable int id) {
        try {
            List<CourseDetailDTO> courseDetailDTOS = courseDetailService.getDetailByID(id);
            return new ResponseEntity<Object>(courseDetailDTOS, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("")
    public Object post(@Valid @RequestBody CourseDetailDTO courseDetailDTO) {
        try {
            courseDetailService.save(courseDetailDTO);
            return new ResponseEntity<Object>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @PutMapping("")
    public Object put(@Valid @RequestBody CourseDetailDTO courseDetailDTO) {
        try {
            courseDetailService.edit(courseDetailDTO);
            return new ResponseEntity<Object>(HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @DeleteMapping("{id}")
    public Object delete(@PathVariable int id) {
        try {
            courseDetailService.deleteById(id);
            return new ResponseEntity<Object>(HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }
}
