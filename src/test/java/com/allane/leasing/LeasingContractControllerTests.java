package com.allane.leasing;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.allane.leasing.entity.Contract;
import com.allane.leasing.util.Constant;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(LeasingContractApplication.class)
class LeasingContractControllerTests extends BaseTest {

	@Test
	void testTheGetResourceToFetchAllContracts() throws Exception{
		given(targetResource.fetchAllContracts())
				.willReturn(new ResponseEntity<List<Contract>>(contractList, HttpStatus.OK));

		mockMvc.perform(
				get(BASE_API_URL + "/contract")
				.contentType(MediaType.APPLICATION_JSON)
		        .accept(MediaType.APPLICATION_JSON))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(status().isOk());
	}
	
	@Test
	void testTheGetResourceToFetchContractByIdentifier() throws Exception{
		given(targetResource.fetchContractById(identifier))
				.willReturn(new ResponseEntity<Contract>(contract, HttpStatus.OK));

		mockMvc.perform(
				get(BASE_API_URL + "/contract/" + identifier)
				.contentType(MediaType.APPLICATION_JSON)
		        .accept(MediaType.APPLICATION_JSON))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(status().isOk());
	}
	
	@Test
	void testThePostResourceToCreateContract() throws Exception{
		Contract newContract = getObjectToUpdate(3l);
		given(targetResource.createContract(newContract))
				.willReturn(new ResponseEntity<Contract>(contract, HttpStatus.OK));

		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(newContract);
		
		mockMvc.perform(post("/api/v1.0/contract")
		           .contentType(MediaType.APPLICATION_JSON)
		           .accept(MediaType.APPLICATION_JSON)
		           .content(jsonInString))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(status().isOk());
	}
	
	@Test
	void testTheDeleteResourceToDeleteContractByIdentifier() throws Exception{
		given(targetResource.deleteContract(identifier))
				.willReturn(new ResponseEntity<String>(Constant.SUCCESS, HttpStatus.OK));

		mockMvc.perform(
				delete(BASE_API_URL + "/contract/" + identifier)
				.contentType(MediaType.APPLICATION_JSON)
		        .accept(MediaType.APPLICATION_JSON))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(status().isOk());
	}
	
	@Test
	void testThePutResourceToUpdateContractByIdentifier() throws Exception{
		Contract updatedContract = getObjectToUpdate(5l);
		given(targetResource.createContract(updatedContract))
				.willReturn(new ResponseEntity<Contract>(contract, HttpStatus.OK));

		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(updatedContract);
		
		mockMvc.perform(
				put(BASE_API_URL + "/contract/" + identifier)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(jsonInString))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(status().isOk());
	}
}
