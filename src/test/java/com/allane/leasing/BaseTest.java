package com.allane.leasing;

import java.util.List;

import org.junit.Before;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.allane.leasing.controller.ContractController;
import com.allane.leasing.entity.Contract;
import com.allane.leasing.entity.Customer;
import com.allane.leasing.entity.Vehicle;
import com.allane.leasing.service.ContractService;

public abstract class BaseTest {
protected static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);
	
	protected static final String BASE_API_URL = "/api/v1.0";

	@Autowired
	protected MockMvc mockMvc;

	@Mock
	protected ContractService contractService;
	
	@MockBean
	protected ContractController targetResource;
	
	protected List<Contract> contractList;
	protected Contract contract;
	protected Long identifier = 1l;
	
	@Before
	public void setUp() throws Exception {
		// product instance uses for adding to list
		contract = new Contract();
		contract.setId(identifier);
		contract.setContractNumber(12345l);
		contract.setMonthlyRate(500d);
		
		Customer customer = new Customer();
		customer.setFirstName("Jahanzaib");
		customer.setLastName("Ali");
		customer.setBirthdate("2000-01-21");
		contract.setCustomer(customer);

		Vehicle vehicle = new Vehicle();
		vehicle.setContract(contract);
		vehicle.setBrand("Honda");
		vehicle.setModel("City");
		vehicle.setModelYear(2008);
		vehicle.setVin("XYZ-1234");
		vehicle.setPrice(20000d);
		contract.setVehicle(vehicle);
		
		contractList.add(contract);
	}
	
	protected Contract getObjectToUpdate(Long id) {
		Contract newContract = new Contract();
		newContract.setId(id);
		newContract.setContractNumber(12345l);
		newContract.setMonthlyRate(500d);
		
		Customer customer = new Customer();
		customer.setFirstName("Markus");
		customer.setLastName("E");
		customer.setBirthdate("1999-01-21");
		newContract.setCustomer(customer);

		Vehicle vehicle = new Vehicle();
		vehicle.setContract(newContract);
		vehicle.setBrand("BMW");
		vehicle.setModel("Series 3");
		vehicle.setModelYear(2005);
		vehicle.setVin("ABC-1234");
		vehicle.setPrice(25000d);
		newContract.setVehicle(vehicle);
		
		return newContract;
	}
}
