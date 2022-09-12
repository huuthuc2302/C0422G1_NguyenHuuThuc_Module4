package com.codegym.model.employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vi_tri")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_vi_tri")
    private Integer id;

    @Column(name = "ten_vi_tri")
    private String name;

    @OneToMany(mappedBy = "position")
    private List<Employee> employeeList;

    public Position() {
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
