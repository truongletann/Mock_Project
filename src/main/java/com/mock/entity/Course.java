package com.mock.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int course_id;
    private String title;
    private String image;
    private String description;
    @Temporal(TemporalType.DATE)
//    @JsonFormat(pattern="yyyy-MM-dd")
    private Date last_update;
    private int number_question;
    private int time_do;
    private int user_id;
    private int category_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private CourseCategory courseCategory;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<UserEnroll> userEnrolls = new ArrayList<UserEnroll>();

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Target> targets= new ArrayList<Target>();

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<CourseDetail> courseDetails = new ArrayList<CourseDetail>();

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Question> questions = new ArrayList<Question>();

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Exam> exams = new ArrayList<Exam>();

    public Course() {
    }

    public Course(int course_id, String title, String image, String description, Date last_update, int number_question, int time_do, int user_id, int category_id) {
        this.course_id = course_id;
        this.title = title;
        this.image = image;
        this.description = description;
        this.last_update = last_update;
        this.number_question = number_question;
        this.time_do = time_do;
        this.user_id = user_id;
        this.category_id = category_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public int getNumber_question() {
        return number_question;
    }

    public void setNumber_question(int number_question) {
        this.number_question = number_question;
    }

    public int getTime_do() {
        return time_do;
    }

    public void setTime_do(int time_do) {
        this.time_do = time_do;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
