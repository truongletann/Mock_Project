package com.mock.dto;

import javax.validation.constraints.NotEmpty;

public class TargetDTO {

    private int target_id;
    @NotEmpty(message = "Please Enter Title !")
    private String target_title;
    private int course_id;

    public TargetDTO() {
    }

    public TargetDTO(int target_id, String target_title, int course_id) {
        this.target_id = target_id;
        this.target_title = target_title;
        this.course_id = course_id;
    }

    public int getTarget_id() {
        return target_id;
    }

    public void setTarget_id(int target_id) {
        this.target_id = target_id;
    }

    public String getTarget_title() {
        return target_title;
    }

    public void setTarget_title(String target_title) {
        this.target_title = target_title;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
}
