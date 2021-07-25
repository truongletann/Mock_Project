package com.mock.service;

import com.mock.dto.CourseDetailDTO;
import com.mock.dto.TargetDTO;

import java.util.List;

public interface CourseDetailService {

    List<CourseDetailDTO> getDetailByID(int id);

    void save(CourseDetailDTO courseDetailDTO);

    void edit(CourseDetailDTO courseDetailDTO);

    void deleteById(int id);


}
