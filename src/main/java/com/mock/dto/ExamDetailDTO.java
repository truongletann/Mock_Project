package com.mock.dto;

import java.util.List;

public class ExamDetailDTO {

    private int exam_detail_id;
    private boolean status_ans;
    private int exam_id;
    private int question_id;
    private QuestionDTO questionDTO;

    public ExamDetailDTO() {
    }

    public int getExam_detail_id() {
        return exam_detail_id;
    }

    public void setExam_detail_id(int exam_detail_id) {
        this.exam_detail_id = exam_detail_id;
    }

    public boolean isStatus_ans() {
        return status_ans;
    }

    public void setStatus_ans(boolean status_ans) {
        this.status_ans = status_ans;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public QuestionDTO getQuestionDTO() {
        return questionDTO;
    }

    public void setQuestionDTO(QuestionDTO questionDTO) {
        this.questionDTO = questionDTO;
    }
}
