package com.example.advanceJPA;

public interface StudentDetailsDAO {
    StudentDetails findStudentDetailsById(int id);

    void createStudentDetails(StudentDetails studentDetails);

    void updateStudentDetails(StudentDetails studentDetails);

    void deleteStudentDetailsById(int id);
}
