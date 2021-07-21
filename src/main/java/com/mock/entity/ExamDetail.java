package com.mock.entity;

import javax.persistence.*;

@Entity
@Table(name = "exam_detail")
public class ExamDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int exam_detail_id;
    private boolean status_ans;
    private int exam_id;
    private int question_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id", insertable = false, updatable = false)
    private Exam exam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", insertable = false, updatable = false)
    private Question question;

    public ExamDetail() {
    }

    public int getExam_detail_id() {
        return exam_detail_id;
    }

    public void setExam_detail_id(int exam_detail_id) {
        this.exam_detail_id = exam_detail_id;
    }

    public boolean isStatus_ans() {
        return status_ans;
    }

    public void setStatus_ans(boolean status_ans) {
        this.status_ans = status_ans;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }
}
