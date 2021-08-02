package com.mock.controller.admin;

import com.mock.dto.CourseCategoryDTO;
import com.mock.dto.RoleDTO;
import com.mock.service.CourseCategoryService;
import com.mock.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin/role")
public class AdminRoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public Object get() {
        try {
            List<RoleDTO> roleDTO = roleService.getAll();
            return new ResponseEntity<Object>(roleDTO, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("{id}")
    public Object get(@PathVariable int id) {
        try {
            RoleDTO category = roleService.getById(id);
            return new ResponseEntity<Object>(category, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("")
    public Object post(@Valid @RequestBody RoleDTO roleDTO) {
        try {
            roleService.save(roleDTO);
            return new ResponseEntity<Object>(HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @PutMapping("")
    public Object put(@Valid @RequestBody RoleDTO roleDTO) {
        try {
            roleService.edit(roleDTO);
            return new ResponseEntity<Object>(HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @DeleteMapping("{id}")
    public Object delete(@PathVariable int id) {
        try {
            roleService.deleteById(id);
            return new ResponseEntity<Object>(HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }
}
