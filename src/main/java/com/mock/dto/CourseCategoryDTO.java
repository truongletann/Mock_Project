package com.mock.dto;

import javax.validation.constraints.NotEmpty;

public class CourseCategoryDTO {
    private int category_id;
    @NotEmpty(message = "Please Enter Title !")
    private String title;
    @NotEmpty(message = "Please Enter Name Icon !")
    private String icon;

    public CourseCategoryDTO() {
    }

    public CourseCategoryDTO(int category_id, String title, String icon) {
        this.category_id = category_id;
        this.title = title;
        this.icon = icon;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
