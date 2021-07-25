package com.mock.dto;

import java.util.Date;

public class UserEnroll {

    private int user_enroll_id;
    private Date date_enroll;
    private int user_id;
    private int course_id;

    public UserEnroll() {
    }

    public UserEnroll(int user_enroll_id, Date date_enroll, int user_id, int course_id) {
        this.user_enroll_id = user_enroll_id;
        this.date_enroll = date_enroll;
        this.user_id = user_id;
        this.course_id = course_id;
    }

    public int getUser_enroll_id() {
        return user_enroll_id;
    }

    public void setUser_enroll_id(int user_enroll_id) {
        this.user_enroll_id = user_enroll_id;
    }

    public Date getDate_enroll() {
        return date_enroll;
    }

    public void setDate_enroll(Date date_enroll) {
        this.date_enroll = date_enroll;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
}
