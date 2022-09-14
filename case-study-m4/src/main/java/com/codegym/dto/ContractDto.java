package com.codegym.dto;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;
import org.springframework.validation.Errors;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.util.Date;

public class ContractDto {

    private Integer contractId;

    @NotBlank(message = "*Không được để trống!")
    private Date startDate;

    @NotBlank(message = "*Không được để trống!")
    private Date endDate;

    @NotBlank(message = "*Không được để trống!")
    private Double deposit;

    private Employee employee;

    private Customer customer;

    private Facility facility;

    public ContractDto() {
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

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        if (!"".equals(contractDto.startDate) && !"".equals(contractDto.endDate)) {
            boolean result = DateTimeUntil.formatterDate(contractDto.startDate, contractDto.endDate);
            if (result) {
                errors.rejectValue("endDate",
                        "create.endDate",
                        "*Ngày kết thúc phải lớn hơn ngày bắt đầu!");

                errors.rejectValue("startDate",
                        "create.startDate",
                        "*Ngày bắt đầu phải bé hơn ngày kết thúc!");
            }
        }
        if (!contractDto.deposit.matches("^?\\d*(\\.\\d+)?$")) {
            errors.rejectValue("deposit",
                    "create.deposit",
                    "*Tiền đặt cọc phải là số nguyên hoặc số thập phân!");
        }

        if (contractDto.customer == null) {
            errors.rejectValue("customer",
                    "create.customer",
                    "*Không được để trống!");
        }

        if (contractDto.employee == null) {
            errors.rejectValue("employee",
                    "create.employee",
                    "*Không được để trống!");
        }

        if (contractDto.facility == null) {
            errors.rejectValue("facility",
                    "create.facility",
                    "*Không được để trống!");
        }
    }
}
