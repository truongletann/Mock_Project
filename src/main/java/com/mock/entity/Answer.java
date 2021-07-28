package com.mock.entity;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ans_id;
    private String ans_content;
    private boolean is_right;
    private int question_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", insertable = false, updatable = false)
    private Question question;

    public Answer() {
    }

    public Answer(String ans_content, boolean is_right, int question_id) {
        this.ans_content = ans_content;
        this.is_right = is_right;
        this.question_id = question_id;
    }

    public Answer(int ans_id, String ans_content, boolean is_right, int question_id) {
        this.ans_id = ans_id;
        this.ans_content = ans_content;
        this.is_right = is_right;
        this.question_id = question_id;
    }

    public int getAns_id() {
        return ans_id;
    }

    public void setAns_id(int ans_id) {
        this.ans_id = ans_id;
    }

    public String getAns_content() {
        return ans_content;
    }

    public void setAns_content(String ans_content) {
        this.ans_content = ans_content;
    }

    public boolean isIs_right() {
        return is_right;
    }

    public void setIs_right(boolean is_right) {
        this.is_right = is_right;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }
}
