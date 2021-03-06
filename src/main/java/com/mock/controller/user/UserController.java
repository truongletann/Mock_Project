package com.mock.controller.user;

import com.mock.dto.UserDTO;
import com.mock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user/userU")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public Object get(@PathVariable int id) {
        try {
            UserDTO dto = userService.getById(id);
            return new ResponseEntity<Object>(dto, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }

    @PutMapping("")
    public Object put(@Valid @RequestBody UserDTO userDTO) {
        try {
            userService.edit(userDTO);
            return new ResponseEntity<Object>(HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }
}
