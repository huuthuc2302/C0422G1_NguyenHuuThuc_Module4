package com.codegym.service.employee;

import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(int id);

    void remove(int id);

    Page<Employee> findByEmployeeNameContaining(String detailEmployee, Pageable pageable);
}
