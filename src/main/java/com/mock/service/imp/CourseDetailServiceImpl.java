package com.mock.service.imp;

import com.mock.dto.CourseDetailDTO;
import com.mock.entity.CourseDetail;
import com.mock.repository.CourseDetailRepository;
import com.mock.repository.CourseRepository;
import com.mock.service.CourseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseDetailServiceImpl implements CourseDetailService {

    @Autowired
    private CourseDetailRepository courseDetailRepository;

    @Override
    public List<CourseDetailDTO> getDetailByID(int id) {
        return courseDetailRepository.getCoursesDetailByID(id);
    }

    @Override
    public void save(CourseDetailDTO courseDetailDTO) {
        if(courseDetailDTO == null){
            return;
        }
        CourseDetail entity = new CourseDetail(
                courseDetailDTO.getCourse_detail_id(),
                courseDetailDTO.getTitle(),
                courseDetailDTO.getUrl(),
                courseDetailDTO.getCourse_id());
        courseDetailRepository.save(entity);
    }

    @Override
    public void edit(CourseDetailDTO courseDetailDTO) {
        if(courseDetailDTO == null){
            return;
        }
        CourseDetail entity = new CourseDetail(
                courseDetailDTO.getCourse_detail_id(),
                courseDetailDTO.getTitle(),
                courseDetailDTO.getUrl(),
                courseDetailDTO.getCourse_id());
        courseDetailRepository.saveAndFlush(entity);
    }

    @Override
    public void deleteById(int id) {
        if(id < 0){
            return;
        }
        courseDetailRepository.deleteById(id);
    }
}
