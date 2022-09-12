package com.codegym.service.contract;

import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {

    Page<Contract> findByCustomerCustomerNameContaining(String detailContract, Pageable pageable);

    List<Contract> findAll();

    void save(Contract contract);

}
