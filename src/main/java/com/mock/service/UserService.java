package com.mock.service;

import com.mock.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAll();

//    void save(CourseDTO courseDTO);
//
//    void edit(CourseDTO courseDTO);

    UserDTO getById(int id);

    void deleteById(int id);
}
