package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "nhan_vien")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nhan_vien")
    private int employeeId;

    @Column(name = "ho_ten")
    private int employeeName;

    @Column(name = "ngay_sinh")
    private String employeeDateOfBirth;

    @Column(name = "so_cmnd")
    private String  employeeIdCard;

    @Column(name = "luong")
    private int  salary;

    @Column(name = "so_dien_thoai")
    private String employeePhone;

    @Column(name = "email")
    private String employeeEmail;

    @Column(name = "dia_chi")
    private String address;

    @Column(name = "ma_vi_tri")
    private String positionId;

    @Column(name = "ma_trinh_do")
    private String educationDegree;

    @Column(name = "ma_bo_phan")
    private String division;

    public Employee() {
    }

    public Employee(int employeeId, int employeeName, String employeeDateOfBirth, String employeeIdCard, int salary,
                    String employeePhone, String employeeEmail, String address, String positionId,
                    String educationDegree, String division) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeDateOfBirth = employeeDateOfBirth;
        this.employeeIdCard = employeeIdCard;
        this.salary = salary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.address = address;
        this.positionId = positionId;
        this.educationDegree = educationDegree;
        this.division = division;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(int employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDateOfBirth() {
        return employeeDateOfBirth;
    }

    public void setEmployeeDateOfBirth(String employeeDateOfBirth) {
        this.employeeDateOfBirth = employeeDateOfBirth;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(String educationDegree) {
        this.educationDegree = educationDegree;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}
