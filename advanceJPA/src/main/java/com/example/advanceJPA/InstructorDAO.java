package com.example.advanceJPA;

import jakarta.persistence.Entity;

import java.util.List;

public interface InstructorDAO {

    Instructor findInstructorById(int id);

    List<Course> findCourseByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

}
