package com.allane.leasing.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.allane.leasing.entity.Contract;
import com.allane.leasing.repository.ContractRepository;
import com.allane.leasing.util.Constant;

@Service("contractService")
public class ContractServiceImpl implements ContractService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ContractService.class);
	private ContractRepository contractRepository;

	@Autowired
	private final void setContractRepository(ContractRepository contractRepository) {
		this.contractRepository = contractRepository;
	}
	
	@Override
	public Contract findContractById(Long id) throws Exception {
		try {
			return contractRepository.findById(id).get();
		} catch (RuntimeException e) {
			LOGGER.info(e.getMessage(), e);
			throw new Exception(e);
		}
	}
	
	@Cacheable("allContracts")
	@Override
	public List<Contract> getAllContracts() throws Exception {
		try {
			return (List<Contract>) contractRepository.findAll();
		} catch (RuntimeException e) {
			LOGGER.info(e.getMessage(), e);
			throw new Exception(e);
		}
	}
	
	@Caching(evict = { @CacheEvict(value = "allContracts", allEntries = true) })
	@Override
	public Contract saveContract(Contract contract) throws Exception {
		try {
			return contractRepository.save(contract);
		} catch (RuntimeException e) {
			LOGGER.info(e.getMessage(), e);
			throw new Exception(e);
		}
	}
	
	@Caching(evict = { @CacheEvict(value = "allContracts", allEntries = true) })
	@Override
	public String deleteContractById(Long id) throws Exception {
		try {
			contractRepository.deleteById(id);
			return Constant.SUCCESS;
		} catch (RuntimeException e) {
			LOGGER.info(e.getMessage(), e);
			throw new Exception(e);
		}
	}
}
