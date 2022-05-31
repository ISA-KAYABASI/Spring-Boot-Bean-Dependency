package com.isakayabasi.crudapplicationspringboot.repository;

import com.isakayabasi.crudapplicationspringboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
