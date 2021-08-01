package com.mock.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_enroll")
public class UserEnroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_enroll_id;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date_enroll;
    private int user_id;
    private int course_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    public UserEnroll() {
    }

    public UserEnroll(Date date_enroll, int user_id, int course_id) {
        this.date_enroll = date_enroll;
        this.user_id = user_id;
        this.course_id = course_id;
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
