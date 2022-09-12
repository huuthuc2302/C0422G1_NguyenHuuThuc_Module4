package com.codegym.model.employee;

import com.codegym.model.contract.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nhan_vien")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nhan_vien")
    private Integer employeeId;

    @Column(name = "ho_ten")
    private String employeeName;

    @Column(name = "ngay_sinh", columnDefinition = "date")
    private String employeeDateOfBirth;

    @Column(name = "so_cmnd")
    private String employeeIdCard;

    @Column(name = "luong")
    private Integer salary;

    @Column(name = "so_dien_thoai")
    private String employeePhone;

    @Column(name = "email")
    private String employeeEmail;

    @Column(name = "dia_chi")
    private String address;

    @ManyToOne
    @JoinColumn(name = "ma_vi_tri", referencedColumnName = "ma_vi_tri")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "ma_trinh_do", referencedColumnName = "ma_trinh_do")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "ma_bo_phan", referencedColumnName = "ma_bo_phan")
    private Division division;

    @OneToMany(mappedBy = "employee")
    private List<Contract> contractList;

    public Employee() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

}
