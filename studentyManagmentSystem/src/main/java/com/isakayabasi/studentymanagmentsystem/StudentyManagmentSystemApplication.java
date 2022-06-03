package com.isakayabasi.studentymanagmentsystem;

import com.isakayabasi.studentymanagmentsystem.entity.Student;
import com.isakayabasi.studentymanagmentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentyManagmentSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentyManagmentSystemApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {

//        Student student1 = new Student("Isa","kayabasi","isakayabasi30@gmail.com");
//        studentRepository.save(student1);
//
//        Student student2 = new Student("Furkan","sahan","furkanSahan@gmail.com");
//        studentRepository.save(student2);
//
//        Student student3 = new Student("Huseyin","gurel","huseyingurel@gmail.com");
//        studentRepository.save(student3);
//
//        Student student4 = new Student("Erdem","yilmaz","erdemyilmaz@gmail.com");
//        studentRepository.save(student4);
    }
}
