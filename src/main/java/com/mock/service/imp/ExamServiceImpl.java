package com.mock.service.imp;

import com.mock.dto.ExamDTO;
import com.mock.dto.ExamDetailDTO;
import com.mock.entity.Exam;
import com.mock.entity.ExamDetail;
import com.mock.repository.ExamDetailRepository;
import com.mock.repository.ExamRepository;
import com.mock.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ExamDetailRepository examDetailRepository;

    @Override
    public List<ExamDTO> getExamByCourseUser(int courseID, int userID) {
        List<ExamDTO> dtos = new ArrayList<ExamDTO>();
        List<Exam> entities = examRepository.getExamByCourseUser(courseID,userID);
        for (Exam entity : entities){
            dtos.add(new ExamDTO(
                    entity.getExam_id(),
                    entity.getTime_need(),
                    entity.getGrade(),
                    entity.getNumber_quiz(),
                    entity.getCourse_id(),
                    entity.getUser_id()));
        }
        return dtos;
    }

    @Override
    public void save(ExamDTO examDTO) {
        if(examDTO == null){
            return;
        }
        Exam exam = new Exam(
                examDTO.getTime_need(),
                examDTO.getGrade(),
                examDTO.getNumber_quiz(),
                examDTO.getCourse_id(),
                examDTO.getUser_id());
        examRepository.save(exam);
        for(ExamDetailDTO examDetailDTO: examDTO.getExamDetailDTO()){
            examDetailRepository.save(new ExamDetail(
                    examDetailDTO.isStatus_ans(),
                    examRepository.getIDEnd(),
                    examDetailDTO.getQuestion_id()));
        }

    }
}
