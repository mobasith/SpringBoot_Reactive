package com.example.SpringbootReactiveSalesCrm.repo;

import com.example.SpringbootReactiveSalesCrm.model.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {
   // Flux<Employee> findByAssignedTo(String Department);  // Custom query to find all employees of a department
}

