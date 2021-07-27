package com.mock.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class CourseDTO {

    private int course_id;
    @NotEmpty(message = "Please Enter Title !")
    private String title;
//    @NotEmpty(message = "Please Enter Title !")
    private String image;
    @NotEmpty(message = "Please Enter Description !")
    private String description;
//    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
    private Date last_update;
    @Min(4)
    private int number_question;
    @Min(240)
    private int time_do;
    private int user_id;
    private int category_id;
    private String category_name;
    private String full_name;

    public CourseDTO() {
    }

    public CourseDTO(int course_id, String title, String image, String description, Date last_update, int number_question, int time_do, int user_id, int category_id, String category_name, String full_name) {
        this.course_id = course_id;
        this.title = title;
        this.image = image;
        this.description = description;
        this.last_update = last_update;
        this.number_question = number_question;
        this.time_do = time_do;
        this.user_id = user_id;
        this.category_id = category_id;
        this.category_name = category_name;
        this.full_name = full_name;
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

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
