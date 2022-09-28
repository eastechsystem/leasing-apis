package com.allane.leasing.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.allane.leasing.service.ContractService;

public abstract class AbstractController {
	protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractController.class);
	protected ContractService contractService;
	
	/**
	 * @param productService
	 */
	@Autowired
	protected final void setContractService(ContractService contractService) {
		this.contractService = contractService;
	}
}
