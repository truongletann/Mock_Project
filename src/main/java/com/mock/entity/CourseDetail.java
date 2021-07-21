package com.mock.entity;

import javax.persistence.*;

@Entity
@Table(name = "course_detail")
public class CourseDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int course_detail_id;
    private String title;
    private String url;
    private int course_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    public CourseDetail() {
    }

    public int getCourse_detail_id() {
        return course_detail_id;
    }

    public void setCourse_detail_id(int course_detail_id) {
        this.course_detail_id = course_detail_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
