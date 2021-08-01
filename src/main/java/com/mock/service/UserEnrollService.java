package com.mock.service;

import com.mock.dto.UserEnrollDTO;
import com.mock.entity.UserEnroll;

import java.util.List;

public interface UserEnrollService {

    List<UserEnrollDTO> getById(int id);

    List<UserEnrollDTO> getByUserCourse(int userID, int courseID);


    void save(UserEnrollDTO userEnrollDTO);
}
