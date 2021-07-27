package com.mock.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course_category")
public class CourseCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;
    private String title;

    @OneToMany(mappedBy = "courseCategory", fetch = FetchType.LAZY)
    private List<Course> courses;

    public CourseCategory() {
    }

    public CourseCategory(String title) {
        this.title = title;
    }

    public CourseCategory(int category_id, String title) {
        this.category_id = category_id;
        this.title = title;
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

}
