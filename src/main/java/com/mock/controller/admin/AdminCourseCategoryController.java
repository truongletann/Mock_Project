package com.mock.controller.admin;

import com.mock.dto.CourseCategoryDTO;
import com.mock.service.CourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin/category")
public class AdminCourseCategoryController {

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

    @GetMapping("{id}")
    public Object get(@PathVariable int id) {
        try {
            CourseCategoryDTO category = courseCategoryService.getById(id);
            return new ResponseEntity<Object>(category, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("")
    public Object post(@Valid @RequestBody CourseCategoryDTO category) {
        try {
            courseCategoryService.save(category);
            return new ResponseEntity<Object>(HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @PutMapping("")
    public Object put(@Valid @RequestBody CourseCategoryDTO category) {
        try {
            courseCategoryService.edit(category);
            return new ResponseEntity<Object>(HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @DeleteMapping("{id}")
    public Object delete(@PathVariable int id) {
        try {
            courseCategoryService.deleteById(id);
            return new ResponseEntity<Object>(HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }
}
