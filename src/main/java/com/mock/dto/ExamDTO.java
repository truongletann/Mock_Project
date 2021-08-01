package com.mock.dto;

import java.util.List;

public class ExamDTO {

    private int exam_id;
    private int time_need;
    private float grade;
    private int number_quiz;
    private int course_id;
    private int user_id;
    private List<ExamDetailDTO> examDetailDTO;

    public ExamDTO() {
    }

    public ExamDTO(int time_need, float grade, int number_quiz, int course_id, int user_id) {
        this.time_need = time_need;
        this.grade = grade;
        this.number_quiz = number_quiz;
        this.course_id = course_id;
        this.user_id = user_id;
    }

    public ExamDTO(int exam_id, int time_need, float grade, int number_quiz, int course_id, int user_id) {
        this.exam_id = exam_id;
        this.time_need = time_need;
        this.grade = grade;
        this.number_quiz = number_quiz;
        this.course_id = course_id;
        this.user_id = user_id;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public int getTime_need() {
        return time_need;
    }

    public void setTime_need(int time_need) {
        this.time_need = time_need;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public int getNumber_quiz() {
        return number_quiz;
    }

    public void setNumber_quiz(int number_quiz) {
        this.number_quiz = number_quiz;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<ExamDetailDTO> getExamDetailDTO() {
        return examDetailDTO;
    }

    public void setExamDetailDTO(List<ExamDetailDTO> examDetailDTO) {
        this.examDetailDTO = examDetailDTO;
    }
}
