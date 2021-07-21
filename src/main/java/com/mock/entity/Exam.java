package com.mock.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "exam")
public class Exam {

    @Id
    private int exam_id;
    private int time_need;
    private float grade;
    private int number_quiz;
    private int course_id;
    private int user_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @OneToMany(mappedBy = "exam", fetch = FetchType.LAZY)
    private List<ExamDetail> examDetails;

    public Exam() {
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
}
