package com.mock.controller.user;

import com.mock.dto.CourseCategoryDTO;
import com.mock.service.CourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/category")
public class UserCourseCategoryController {

    @Autowired
    private CourseCategoryService courseCategoryService;

    @GetMapping("")
    public Object get() {
        try {
            List<CourseCategoryDTO> listCategory = courseCategoryService.getAll();
            return new ResponseEntity<Object>(listCategory, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }
}
