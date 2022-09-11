package com.codegym.repository.employee;

import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    Page<Employee> findByEmployeeNameContaining(String detailEmployee, Pageable pageable);

}
