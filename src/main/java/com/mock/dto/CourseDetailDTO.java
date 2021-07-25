package com.mock.dto;

public class CourseDetailDTO {
    private int course_detail_id;
    private String title;
    private String url;
    private int course_id;

    public CourseDetailDTO() {
    }

    public CourseDetailDTO(int course_detail_id, String title, String url, int course_id) {
        this.course_detail_id = course_detail_id;
        this.title = title;
        this.url = url;
        this.course_id = course_id;
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
}
