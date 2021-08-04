package com.mock.controller.user;

import com.mock.dto.LoginDTO;
import com.mock.dto.RoleDTO;
import com.mock.dto.UserDTO;
import com.mock.service.AuthService;
import com.mock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user/auth")
public class UserAuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @PostMapping("")
    public Object post(@RequestBody LoginDTO account) {
        try {
            String token = authService.login(account);
            return new ResponseEntity<Object>(token, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register")
    public Object post(@Valid @RequestBody UserDTO userDTO) {
        try {
            userService.save(userDTO);
            return new ResponseEntity<Object>(HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

        }
    }
}
