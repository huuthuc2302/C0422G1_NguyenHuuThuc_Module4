package com.codegym.model.contract;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "hop_dong")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hop_dong")
    private Integer contractId;

    @Column(name = "ngay_lam_hop_dong")
    private Date startDate;

    @Column(name = "ngay_ket_thuc")
    private Date endDate;

    @Column(name = "tien_dat_coc")
    private Double deposit;

    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma_nhan_vien")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "ma_khach_hang", referencedColumnName = "ma_khach_hang")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "ma_dich_vu", referencedColumnName = "ma_dich_vu")
    private Facility facility;

    @OneToMany(mappedBy = "contract")
    private List<ContractDetail> contractDetailList;

    public Contract() {
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }
}
