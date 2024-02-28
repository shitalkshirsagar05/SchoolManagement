package com.InfoStack.schoolmanagement.models;

import javax.persistence.*;

@Entity
@Table(name = "tbl_teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    int teacherId;
    @Column(name = "teacher_name")
    String teacherName;
    @Column(name = "teacher_salary")
    int teacherSalary;
    @Column(name = "teacher_subject")
    String teacherSubject;

    public Teacher() {
    }

    public Teacher(int teacherId, String teacherName, int teacherSalary, String teacherSubject) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherSalary = teacherSalary;
        this.teacherSubject = teacherSubject;
    }

    public Teacher(String teacherName, int teacherSalary, String teacherSubject) {
        this.teacherName = teacherName;
        this.teacherSalary = teacherSalary;
        this.teacherSubject = teacherSubject;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getTeacherSalary() {
        return teacherSalary;
    }

    public void setTeacherSalary(int teacherSalary) {
        this.teacherSalary = teacherSalary;
    }

    public String getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(String teacherSubject) {
        this.teacherSubject = teacherSubject;
    }
}
