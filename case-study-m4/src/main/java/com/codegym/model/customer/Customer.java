package com.codegym.model.customer;

import com.codegym.model.contract.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "khach_hang")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_khach_hang")
    private int customerId;

    @Column(name = "ho_ten")
    private String customerName;

    @Column(name = "ngay_sinh")
    private String  customerBirth;

    @Column(name = "gioi_tinh")
    private int  customerGender;

    @Column(name = "so_cmnd")
    private String customerIdCard;

    @Column(name = "so_dien_thoai")
    private String customerPhone;

    @Column(name = "email")
    private String customerEmail;

    @Column(name = "dia_chi")
    private String customerAddress;

    @ManyToOne
    @JoinColumn(name = "ma_loai_khach", referencedColumnName = "ma_loai_khach")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    private List<Contract> contractList;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerBirth, int customerGender,
                    String customerIdCard, String customerPhone, String customerEmail,
                    String customerAddress, CustomerType customerType) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerBirth = customerBirth;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerType = customerType;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirth() {
        return customerBirth;
    }

    public void setCustomerBirth(String customerBirth) {
        this.customerBirth = customerBirth;
    }

    public int getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(int customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
