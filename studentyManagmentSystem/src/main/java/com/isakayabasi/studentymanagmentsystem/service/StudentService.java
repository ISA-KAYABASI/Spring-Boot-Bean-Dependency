package com.isakayabasi.studentymanagmentsystem.service;

import com.isakayabasi.studentymanagmentsystem.entity.Student;

import java.util.List;

public interface StudentService {
    List< Student > getAllStudent();

    Student saveStudent(Student student);

    Student getStudentById(Long id);
    Student updateStudent(Student student);

    void deleteStudentById(Long id);
}
