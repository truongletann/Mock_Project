package com.mock.service.imp;

import com.mock.dto.CourseDTO;
import com.mock.entity.Course;
import com.mock.repository.CourseDetailRepository;
import com.mock.repository.CourseRepository;
import com.mock.service.CourseCategoryService;
import com.mock.service.CourseService;
import com.mock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseCategoryService courseCategoryService;

    @Autowired
    private UserService userService;

    @Override
    public List<CourseDTO> getAll() {
        List<Course> entities = courseRepository.findAll();
        List<CourseDTO> dtos = new ArrayList<CourseDTO>();
        for(Course entity : entities){
            dtos.add(new CourseDTO(
                    entity.getCourse_id(),
                    entity.getTitle(),
                    entity.getImage(),
                    entity.getDescription(),
                    entity.getLast_update(),
                    entity.getNumber_question(),
                    entity.getTime_do(),
                    entity.getUser_id(),
                    entity.getCategory_id(),
                    courseCategoryService.getById(entity.getCategory_id()).getTitle(),
                    userService.getById(entity.getUser_id()).getFull_name()));
        }
        return dtos;
    }

    @Override
    public void save(CourseDTO courseDTO) {
        if(courseDTO == null){
            return;
        }
        Course entity = new Course(
                courseDTO.getCourse_id(),
                courseDTO.getTitle(),
                courseDTO.getImage(),
                courseDTO.getDescription(),
                courseDTO.getLast_update(),
                courseDTO.getNumber_question(),
                courseDTO.getTime_do(),
                courseDTO.getUser_id(),
                courseDTO.getCategory_id());
        courseRepository.save(entity);
    }

    @Override
    public void edit(CourseDTO courseDTO) {
        if(courseDTO == null){
            return;
        }
        Course entity = new Course(
                courseDTO.getCourse_id(),
                courseDTO.getTitle(),
                courseDTO.getImage(),
                courseDTO.getDescription(),
                courseDTO.getLast_update(),
                courseDTO.getNumber_question(),
                courseDTO.getTime_do(),
                courseDTO.getUser_id(),
                courseDTO.getCategory_id());
        courseRepository.saveAndFlush(entity);
    }

    @Override
    public void deleteById(int id) {
        if(id < 0){
            return;
        }
        courseRepository.deleteById(id);

    }

    @Override
    public CourseDTO getById(int id) {
        if(id < 0){
            return null;
        }
        Course entity = courseRepository.findById(id).get();
        return new CourseDTO(
                entity.getCourse_id(),
                entity.getTitle(),
                entity.getImage(),
                entity.getDescription(),
                entity.getLast_update(),
                entity.getNumber_question(),
                entity.getTime_do(),
                entity.getUser_id(),
                entity.getCategory_id(),
                courseCategoryService.getById(entity.getCategory_id()).getTitle(),
                userService.getById(entity.getUser_id()).getFull_name());
    }

    @Override
    public List<CourseDTO> getByName(String name) {
        List<CourseDTO> dtos = new ArrayList<CourseDTO>();
        List<Course> entities = courseRepository.getCourseByName(name);
        for (Course entity : entities){
            dtos.add(new CourseDTO(
                    entity.getCourse_id(),
                    entity.getTitle(),
                    entity.getImage(),
                    entity.getDescription(),
                    entity.getLast_update(),
                    entity.getNumber_question(),
                    entity.getTime_do(),
                    entity.getUser_id(),
                    entity.getCategory_id(),
                    courseCategoryService.getById(entity.getCategory_id()).getTitle(),
                    userService.getById(entity.getUser_id()).getFull_name()));
        }
        return dtos;
    }
}
