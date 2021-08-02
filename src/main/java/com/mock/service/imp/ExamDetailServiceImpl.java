package com.mock.service.imp;

import com.mock.dto.ExamDetailDTO;
import com.mock.entity.ExamDetail;
import com.mock.repository.ExamDetailRepository;
import com.mock.service.ExamDetailService;
import com.mock.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamDetailServiceImpl implements ExamDetailService {

    @Autowired
    private ExamDetailRepository examDetailRepository;

    @Autowired
    private QuestionService questionService;

    @Override
    public List<ExamDetailDTO> getByExamID(int examID) {
        if(examID <0){
            return null;
        }
        List<ExamDetail> examDetail = examDetailRepository.getExamDetailByID(examID);
        List<ExamDetailDTO> examDetailDTO = new ArrayList<ExamDetailDTO>();
        for(ExamDetail entity: examDetail){
            examDetailDTO.add(new ExamDetailDTO(
                    entity.getExam_detail_id(),
                    entity.isStatus_ans(),
                    entity.getExam_id(),
                    entity.getQuestion_id(),
                    questionService.getById(entity.getQuestion_id())));
        }

        return examDetailDTO;
    }
}
