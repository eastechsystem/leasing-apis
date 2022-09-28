package com.allane.leasing.repository;

import org.springframework.data.repository.CrudRepository;

import com.allane.leasing.entity.Contract;

public interface ContractRepository extends CrudRepository<Contract, Long> {

}
