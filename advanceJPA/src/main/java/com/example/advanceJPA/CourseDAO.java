package com.example.advanceJPA;

public interface CourseDAO {

    void createCourse(Course course);

    void createCourse(Course course, int instructorId);

    Course findCourseById(int id);

    Course findCourseAndStudentById(int id);
}
