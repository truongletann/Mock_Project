package com.mock.controller.admin;


import com.mock.dto.LoginDTO;
import com.mock.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/auth")
public class AdminAuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("")
    public Object post(@RequestBody LoginDTO account) {
        try {
            String token = authService.login(account);
            return new ResponseEntity<Object>(token, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }
}
