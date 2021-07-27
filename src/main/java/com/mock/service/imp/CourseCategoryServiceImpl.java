package com.mock.service.imp;

import com.mock.dto.CourseCategoryDTO;
import com.mock.entity.CourseCategory;
import com.mock.repository.CourseCategoryRepository;
import com.mock.service.CourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseCategoryServiceImpl implements CourseCategoryService {

    @Autowired
    private CourseCategoryRepository courseCategoryRepository;

    @Override
    public List<CourseCategoryDTO> getAll() {
        List<CourseCategoryDTO> listCategoryDTO = new ArrayList<CourseCategoryDTO>();
        List<CourseCategory> listCategory = courseCategoryRepository.findAll();

        for (CourseCategory entity : listCategory){
            listCategoryDTO.add(new CourseCategoryDTO(
                    entity.getCategory_id(),
                    entity.getTitle()));
        }
        return listCategoryDTO;
    }

    @Override
    public void save(CourseCategoryDTO courseCategoryDTO) {
        if(courseCategoryDTO == null){
            return;
        }
        CourseCategory entity = new CourseCategory(
                courseCategoryDTO.getTitle());
        courseCategoryRepository.save(entity);
    }

    @Override
    public void edit(CourseCategoryDTO courseCategoryDTO) {
        if(courseCategoryDTO == null){
            return;
        }
        CourseCategory entity = new CourseCategory(
                courseCategoryDTO.getCategory_id(),
                courseCategoryDTO.getTitle());
        courseCategoryRepository.saveAndFlush(entity);
    }

    @Override
    public void deleteById(int id) {
        if(id < 0){
            return;
        }
        courseCategoryRepository.deleteById(id);
    }

    @Override
    public CourseCategoryDTO getById(int id) {
        if(id<0){
            return null;
        }
        CourseCategory entity = courseCategoryRepository.findById(id).get();
        return new CourseCategoryDTO(entity.getCategory_id(),entity.getTitle());
    }
}
