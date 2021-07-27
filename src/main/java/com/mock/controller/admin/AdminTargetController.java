package com.mock.controller.admin;

import com.mock.dto.CourseCategoryDTO;
import com.mock.dto.TargetDTO;
import com.mock.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin/target")
public class AdminTargetController {

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
    @GetMapping("{id}")
    public Object get(@PathVariable int id) {
        try {
            TargetDTO targetDTO = targetService.getById(id);
            return new ResponseEntity<Object>(targetDTO, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("")
    public Object post(@Valid @RequestBody TargetDTO targetDTO) {
        try {
            targetService.save(targetDTO);
            return new ResponseEntity<Object>(HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @PutMapping("")
    public Object put(@Valid @RequestBody TargetDTO targetDTO) {
        try {
            targetService.edit(targetDTO);
            return new ResponseEntity<Object>(HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @DeleteMapping("{id}")
    public Object delete(@PathVariable int id) {
        try {
            targetService.deleteById(id);
            return new ResponseEntity<Object>(HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }
}
