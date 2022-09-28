package com.allane.leasing.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.allane.leasing.entity.Contract;
import com.allane.leasing.util.Constant;

/**
 * This class provides the rest web services/APIs for contract operations.
 *
 * @author jahanzaib.ali
 * 
 */
@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/v1.0")
public class ContractController extends AbstractController {

	/**
	 * @return
	 */
	@GetMapping(value = "/contract")
	@ResponseBody
	public ResponseEntity<List<Contract>> fetchAllContracts() {
		LOGGER.info("fetchAllContracts() Webservice starts!");

		List<Contract> contracts = null;
		try {
			contracts = contractService.getAllContracts();
			if (null != contracts) {
				return new ResponseEntity<List<Contract>>(contracts, HttpStatus.OK);
			}
		} catch (Exception e) {
			LOGGER.info(e.getMessage(), e);
			return new ResponseEntity<List<Contract>>(HttpStatus.BAD_REQUEST);
		}

		LOGGER.info("fetchAllContracts() Webservice ends!");
		return new ResponseEntity<List<Contract>>(contracts, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * @param identifier
	 * @return
	 */
	@GetMapping(value = "/contract/{identifier}")
	@ResponseBody
	public ResponseEntity<Contract> fetchContractById(@PathVariable("identifier") Long identifier) {
		LOGGER.info("fetchAllContracts() Webservice starts!");

		Contract contract = null;
		try {
			contract = contractService.findContractById(identifier);
			if (null != contract) {
				return new ResponseEntity<Contract>(contract, HttpStatus.OK);
			}
		} catch (Exception e) {
			LOGGER.info(e.getMessage(), e);
			return new ResponseEntity<Contract>(HttpStatus.BAD_REQUEST);
		}

		LOGGER.info("fetchAllContracts() Webservice ends!");
		return new ResponseEntity<Contract>(contract, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * @param contract
	 * @return
	 */
	@PostMapping("/contract")
	@ResponseBody
	public ResponseEntity<Contract> createContract(@RequestBody Contract contract) {
		LOGGER.info("createContract() Webservice starts!");

		try {
			Contract saveContract = contractService.saveContract(contract);
			if (null != saveContract) {
				return new ResponseEntity<Contract>(saveContract, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			LOGGER.info(e.getMessage(), e);
			return new ResponseEntity<Contract>(HttpStatus.BAD_REQUEST);
		}

		LOGGER.info("createContract() Webservice ends!");
		return new ResponseEntity<Contract>(HttpStatus.NOT_ACCEPTABLE);
	}

	/**
	 * @param identifier
	 * @return
	 */
	@DeleteMapping("/contract/{identifier}")
	@ResponseBody
	public ResponseEntity<String> deleteContract(@PathVariable("identifier") Long identifier) {
		LOGGER.info("deleteContract() Webservice starts!");

		try {
			String message = contractService.deleteContractById(identifier);
			if (Constant.SUCCESS.equals(message)) {
				return new ResponseEntity<String>(Constant.SUCCESS, HttpStatus.OK);
			}
		} catch (Exception e) {
			LOGGER.info(e.getMessage(), e);
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		LOGGER.info("deleteContract() Webservice ends!");
		return new ResponseEntity<String>(Constant.FAILURE, HttpStatus.NOT_ACCEPTABLE);
	}

	/**
	 * @param identifier
	 * @param contract
	 * @return
	 */
	@PutMapping("/contract/{identifier}")
	@ResponseBody
	public ResponseEntity<String> updateContract(@PathVariable("identifier") Long identifier, @RequestBody Contract contract) {
		LOGGER.info("updateContract() Webservice starts!");

		try {
			Contract storedContract = contractService.findContractById(identifier);
			if (null == storedContract) {
				return new ResponseEntity<String>(Constant.FAILURE, HttpStatus.NOT_FOUND);
			}
			contract.setId(storedContract.getId());
			contractService.saveContract(contract);
		} catch (Exception e) {
			LOGGER.info(e.getMessage(), e);
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		LOGGER.info("updateContract() Webservice ends!");
		return new ResponseEntity<String>(Constant.SUCCESS, HttpStatus.OK);
	}
}
