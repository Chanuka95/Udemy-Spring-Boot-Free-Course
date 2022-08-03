package com.udemy.udemyboottutorial.repository;

import com.udemy.udemyboottutorial.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
