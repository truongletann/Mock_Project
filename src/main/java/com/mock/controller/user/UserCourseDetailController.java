package com.mock.controller.user;

import com.mock.dto.CourseDetailDTO;
import com.mock.service.CourseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/userau/course-detail")
public class UserCourseDetailController {

    @Autowired
    private CourseDetailService courseDetailService;

    @GetMapping("by-course/{id}")
    public Object getByCourse(@PathVariable int id) {
        try {
            List<CourseDetailDTO> courseDetailDTOS = courseDetailService.getDetailByID(id);
            return new ResponseEntity<Object>(courseDetailDTOS, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }
}
