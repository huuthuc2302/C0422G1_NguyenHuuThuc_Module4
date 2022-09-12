package com.codegym.repository.contract;

import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Integer> {

    Page<Contract> findByCustomerCustomerNameContaining(String detailContract, Pageable pageable);

}
