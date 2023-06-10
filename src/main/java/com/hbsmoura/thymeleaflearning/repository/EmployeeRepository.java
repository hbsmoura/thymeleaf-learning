package com.hbsmoura.thymeleaflearning.repository;

import com.hbsmoura.thymeleaflearning.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
