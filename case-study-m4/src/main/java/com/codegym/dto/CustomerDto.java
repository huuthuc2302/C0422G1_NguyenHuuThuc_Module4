package com.codegym.dto;

import com.codegym.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.Period;

public class CustomerDto implements Validator {

    private int customerId;

    @NotBlank(message = "Vui lòng nhập thông tin!")
    private String customerName;

    private String customerBirth;

    private int customerGender;

    @NotBlank(message = "Vui lòng nhập thông tin!")
    private String customerIdCard;

    @NotBlank(message = "Vui lòng nhập thông tin!")
    private String customerPhone;

    @Email(message = "Email nhập sai định dạng!")
    @NotBlank(message = "Vui lòng nhập thông tin!")
    private String customerEmail;

    @NotBlank(message = "Vui lòng nhập thông tin!")
    private String customerAddress;

    private CustomerType customerType;


    public CustomerDto() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;

        String customerDtoName = customerDto.getCustomerName();
        String customerDtoPhone = customerDto.getCustomerPhone();
        String customerDtoIdCard = customerDto.getCustomerIdCard();

        if (!customerDtoName.matches("^([A-Z]{1}[a-z]{1,}\\s{1}){1,}([A-Z]{1}[a-z]{1,})+$")) {
            errors.rejectValue("customerName", "customerDtoName", "Kí tự đầu tiên của mỗi từ phải viết hoa");
        }
        if (!customerDtoPhone.matches("^(091|090|\\(\\+84\\)90|\\(\\+84\\)91)\\d{7}+$")) {
            errors.rejectValue("customerPhone", "customerDtoPhone", "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx");
        }
        if (!customerDtoIdCard.matches("^\\d{9}+$")) {
            errors.rejectValue("customerIdCard", "customerDtoIdCard", "Số CMND phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX");
        }

        LocalDate now = LocalDate.now();
        LocalDate dateOfBirth = null;
        try {
            dateOfBirth = LocalDate.parse(customerDto.getCustomerBirth());
            if (Period.between(dateOfBirth, now).getYears() < 18 || Period.between(dateOfBirth, now).getYears() > 100) {
                errors.rejectValue("customerBirth", "dateOfBirth.err", "Tuổi nhập vào phải từ 18-120!");
            }
        } catch (Exception e) {
            errors.rejectValue("customerBirth", "dateOfBirth,err", "Vui lòng nhập lại!");
        }
    }
}
