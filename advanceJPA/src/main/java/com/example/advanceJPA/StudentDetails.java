package com.example.advanceJPA;

import jakarta.persistence.*;

@Entity
@Table(name = "student_details")
public class StudentDetails {

    @Id
    private int studentId;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "age")
    private int age;

    public StudentDetails() {
    }

    public StudentDetails(int age) {
        this.age = age;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}