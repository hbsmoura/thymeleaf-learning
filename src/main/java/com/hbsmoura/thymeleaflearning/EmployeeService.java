package com.hbsmoura.thymeleaflearning;

import com.hbsmoura.thymeleaflearning.model.Employee;
import com.hbsmoura.thymeleaflearning.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> list() {
        return repository.findAll();
    }

    public void save(Employee employee) {
        repository.save(employee);
    }

    public Employee getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id= " + id));
    }

    public void delete(Employee employee) {
        repository.delete(employee);
    }
}
