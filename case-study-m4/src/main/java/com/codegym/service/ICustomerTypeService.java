package com.codegym.service;

import com.codegym.model.Customer.Customer;
import com.codegym.model.Customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {

    List<CustomerType> findAll();

}
