package com.example.exceptiondemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {

    private static List<Student> students = new ArrayList<>();
    static {
        Student student = new Student();
        student.setId(1);
        student.setName("soham");
        students.add(student);
        student = new Student();
        student.setId(2);
        student.setName("sam");
        students.add(student);
    }

    @GetMapping(path={"/students", "/pupils"})
    public List<Student> getStudents() {
        return this.students;
    }

    @GetMapping("/students/{studentId:[0-9]}")
    public Student getStudentById(@PathVariable int studentId){
        studentId--;
        if (studentId >= this.students.size() || studentId < 0) {
            throw new StudentException("Student ID not found");
        }
        return this.students.get(studentId);
    }

//    @ExceptionHandler
//    public ResponseEntity<StudentExceptionResponse> handleStudentNotFoundException(StudentException studentException) {
//        StudentExceptionResponse studentExceptionResponse = new StudentExceptionResponse(
//                HttpStatus.NOT_FOUND.value(),
//                studentException.getMessage(),
//                System.currentTimeMillis()
//        );
//
//        return new ResponseEntity<>(studentExceptionResponse, HttpStatus.NOT_FOUND);
//    }

    @GetMapping("/students/search")
    public Student getStudentByName(@RequestParam(value = "name", required = false, defaultValue = "soham") String name) {
        return this.students.get(0);
    }
}
