package com.example.SpringbootReactiveSalesCrm.service;

import com.example.SpringbootReactiveSalesCrm.model.Employee;
import com.example.SpringbootReactiveSalesCrm.repo.EmployeeRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Flux<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Mono<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }

    public Mono<Employee> createEmployee(Employee employee) {
        //employee.setCreatedAt(LocalDateTime.now());
        //employee.setUpdatedAt(LocalDateTime.now());
        return employeeRepository.save(employee);
    }

    public Mono<Employee> updateEmployee(String id, Employee updatedEmployee) {
        return employeeRepository.findById(id)
                .flatMap(existingEmployee -> {
                    updatedEmployee.setEid(existingEmployee.getEid());
                    //updatedEmployee.setUpdatedAt(LocalDateTime.now());
                    return employeeRepository.save(updatedEmployee);
                });
    }

    public Mono<Void> deleteEmployee(String id) {
        return employeeRepository.deleteById(id);
    }

   /* public Flux<Employee> getCustomersByAssignedTo(String assignedTo) {
        return employeeRepository.findByAssignedTo(assignedTo);
    }*/
}

