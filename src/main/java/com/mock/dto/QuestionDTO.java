package com.mock.dto;

import java.util.List;

public class QuestionDTO {

    private int question_id;
    private String question_content;
    private int course_id;
    private List<AnswerDTO> listAns;

    public QuestionDTO() {
    }

    public QuestionDTO(int question_id, String question_content, int course_id) {
        this.question_id = question_id;
        this.question_content = question_content;
        this.course_id = course_id;
    }

    public QuestionDTO(int question_id, String question_content, int course_id, List<AnswerDTO> listAns) {
        this.question_id = question_id;
        this.question_content = question_content;
        this.course_id = course_id;
        this.listAns = listAns;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestion_content() {
        return question_content;
    }

    public void setQuestion_content(String question_content) {
        this.question_content = question_content;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public List<AnswerDTO> getListAns() {
        return listAns;
    }

    public void setListAns(List<AnswerDTO> listAns) {
        this.listAns = listAns;
    }
}
