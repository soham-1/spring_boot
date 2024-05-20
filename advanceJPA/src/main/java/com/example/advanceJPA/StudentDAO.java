package com.example.advanceJPA;

public interface StudentDAO {
    Student findStudentById(int id);

    void createStudent(Student student);

    void updateStudent(Student student);

    void deleteStudentById(int id);
}
