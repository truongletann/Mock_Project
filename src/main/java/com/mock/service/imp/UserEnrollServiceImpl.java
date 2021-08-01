package com.mock.service.imp;

import com.mock.dto.UserEnrollDTO;
import com.mock.entity.Target;
import com.mock.entity.UserEnroll;
import com.mock.repository.CourseRepository;
import com.mock.repository.UserEnrollRepository;
import com.mock.service.CourseService;
import com.mock.service.UserEnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserEnrollServiceImpl implements UserEnrollService {

    @Autowired
    private UserEnrollRepository userEnrollRepository;

    @Autowired
    private CourseService courseService;

    @Override
    public List<UserEnrollDTO> getById(int id) {
        List<UserEnrollDTO> dtos = new ArrayList<UserEnrollDTO>();
        List<UserEnroll> entities = userEnrollRepository.getUserEnrollByID(id);
        for (UserEnroll entity : entities){
            dtos.add(new UserEnrollDTO(
               entity.getUser_enroll_id(),
               entity.getDate_enroll(),
               entity.getUser_id(),
               entity.getCourse_id(),
               courseService.getById(entity.getCourse_id())));
        }
        return dtos;
    }

    @Override
    public List<UserEnrollDTO> getByUserCourse(int userID, int courseID) {
        List<UserEnrollDTO> dtos = new ArrayList<UserEnrollDTO>();
        List<UserEnroll> entities = userEnrollRepository.checkButton(userID, courseID);
        for (UserEnroll entity : entities){
            dtos.add(new UserEnrollDTO(
                    entity.getUser_enroll_id(),
                    entity.getDate_enroll(),
                    entity.getUser_id(),
                    entity.getCourse_id(),
                    courseService.getById(entity.getCourse_id())));
        }
        return dtos;
    }

    @Override
    public void save(UserEnrollDTO userEnrollDTO) {
        if(userEnrollDTO == null){
            return;
        }
        UserEnroll entity = new UserEnroll(
                userEnrollDTO.getDate_enroll(),
                userEnrollDTO.getUser_id(),
                userEnrollDTO.getCourse_id());
        userEnrollRepository.save(entity);
    }
}
