package com.codegym.model.employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bo_phan")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_bo_phan")
    private Integer id;

    @Column(name = "ten_bo_phan")
    private String name;

    @OneToMany(mappedBy = "division")
    private List<Employee> employeeList;

    public Division() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
