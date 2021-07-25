package com.mock.service;

import com.mock.dto.CourseCategoryDTO;

import java.util.List;

public interface CourseCategoryService {

    List<CourseCategoryDTO> getAll();

    void save(CourseCategoryDTO courseCategoryDTO);

    void edit(CourseCategoryDTO courseCategoryDTO);

    void deleteById(int id);

    CourseCategoryDTO getById(int id);

}
