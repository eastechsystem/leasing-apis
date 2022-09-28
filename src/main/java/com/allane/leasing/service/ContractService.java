package com.allane.leasing.service;

import java.util.List;

import com.allane.leasing.entity.Contract;

public interface ContractService {

	public Contract findContractById(Long id) throws Exception;

	public List<Contract> getAllContracts() throws Exception;

	public Contract saveContract(Contract contract) throws Exception;

	public String deleteContractById(Long id) throws Exception;

}
