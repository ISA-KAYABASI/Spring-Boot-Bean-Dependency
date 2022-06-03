package com.isakayabasi.studentymanagmentsystem.repository;

import com.isakayabasi.studentymanagmentsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StudentRepository extends JpaRepository<Student,Long> {

}
