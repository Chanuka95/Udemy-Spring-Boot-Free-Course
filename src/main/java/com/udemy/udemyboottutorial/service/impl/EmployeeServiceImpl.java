package com.udemy.udemyboottutorial.service.impl;

import com.udemy.udemyboottutorial.exception.ResourceNotFoudException;
import com.udemy.udemyboottutorial.model.Employee;
import com.udemy.udemyboottutorial.repository.EmployeeRepository;
import com.udemy.udemyboottutorial.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional <Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()){
            return employee.get();
        }else{
           throw new ResourceNotFoudException("Employee", "id", id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {

        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoudException("Employee", "Id", id));

        existingEmployee.setEmpFirstName(employee.getEmpFirstName());
        existingEmployee.setEmpLastName(employee.getEmpLastName());
        existingEmployee.setEmpEmail(employee.getEmpEmail());
        // save existing employee to DB
        employeeRepository.save(existingEmployee);
        return existingEmployee;

    }
}
