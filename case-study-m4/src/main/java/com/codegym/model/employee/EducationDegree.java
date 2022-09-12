package com.codegym.model.employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trinh_do")
public class EducationDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_trinh_do")
    private Integer id;

    @Column(name = "ten_trinh_do")
    private String name;

    @OneToMany(mappedBy = "educationDegree")
    private List<Employee> employeeList;

    public EducationDegree() {
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
