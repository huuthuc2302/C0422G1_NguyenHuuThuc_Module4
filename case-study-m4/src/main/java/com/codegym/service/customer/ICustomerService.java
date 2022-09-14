package com.codegym.service.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(Integer id);

    void remove(Integer id);

    Page<Customer> findByCustomerNameContaining(String detailCustomer, Pageable pageable);

}
