package com.codegym.service.contract.impl;

import com.codegym.model.contract.Contract;
import com.codegym.repository.contract.IContractRepository;
import com.codegym.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Page<Contract> findByCustomerCustomerNameContaining(String detailContract, Pageable pageable) {
        return iContractRepository.findByCustomerCustomerNameContaining(detailContract, pageable);
    }

    @Override
    public List<Contract> findAll() {
        return iContractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

}
