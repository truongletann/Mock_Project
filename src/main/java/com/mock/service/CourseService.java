package com.mock.service;


import com.mock.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    List<CourseDTO> getAll();

    void save(CourseDTO courseDTO);

    void edit(CourseDTO courseDTO);

    void deleteById(int id);

    CourseDTO getById(int id);
}
