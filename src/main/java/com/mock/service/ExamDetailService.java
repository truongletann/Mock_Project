package com.mock.service;

import com.mock.dto.ExamDetailDTO;

import java.util.List;

public interface ExamDetailService {

    List<ExamDetailDTO> getByExamID(int examID);
}
