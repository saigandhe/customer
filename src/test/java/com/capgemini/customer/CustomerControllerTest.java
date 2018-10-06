package com.capgemini.customer;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.customer.controller.CustomerController;
import com.capgemini.customer.model.Customer;
import com.capgemini.customer.service.CustomerService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest

public class CustomerControllerTest {

	@InjectMocks
	private CustomerController customerController;
	@Mock
	private CustomerService customerService;
	private MockMvc mockMvc;
	
	Customer customer;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
		customer = new Customer();
		customer.setCustomerId(15);
		customer.setCustomerPassword("Naina");
		customer.setCustomerName("Nikki");
		customer.setCustomerAddress("ShivajiNagar");
		customer.setCustomerEmailId("naina@gmail.com");
		customer.setMobileNo(987654321);
	}
	
	@Test
	public void testAddEmployee() throws Exception{
		when(customerService.addCustomer(Mockito.isA(Customer.class))).thenReturn(customer);
		mockMvc.perform(post("/Customer")
		.contentType(MediaType.APPLICATION_JSON_UTF8)
		.content("{ \"customerId\": \"15\", \"customerPassword\":\"Naina\",\"customerName\" : \"Nikki\", \"customerAddress\" : \"ShivajiNagar\",\"customerEmailId\":\"naina@gmail.com\",\"mobileNo\":\"987654321\" }")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.customerId").value(15))
		.andExpect(jsonPath("$.customerPassword").value("Naina"))
		.andExpect(jsonPath("$.customerName").value("Nikki"))
		.andExpect(jsonPath("$.customerAddress").value("ShivajiNagar"))
		.andExpect(jsonPath("$.customerEmailId").value("naina@gmail.com"))
		.andExpect(jsonPath("$.mobileNo").value(987654321))
		.andDo(print());
		
	}
	
	@Test
	public void testUpdateCustomer() throws Exception{
			customer.setCustomerName("Sushmitha");
			customer.setCustomerEmailId("Sadvi@gmail.com");
			customer.setMobileNo(987654320);
			
		when(customerService.updateCustomer(Mockito.isA(Customer.class))).thenReturn(customer);
			mockMvc.perform(put("/Customer")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content("{ \"customerId\": \"15\", \"customerPassword\":\"Naina\",\"customerName\" : \"Sushmitha\", \"customerAddress\" : \"ShivajiNagar\",\"customerEmailId\":\"Sadvi@gmail.com\",\"mobileNo\":\"987654320\" }")
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.customerId").value(15))
			.andExpect(jsonPath("$.customerPassword").value("Naina"))
			.andExpect(jsonPath("$.customerName").value("Sushmitha"))
			.andExpect(jsonPath("$.customerAddress").value("ShivajiNagar"))
			.andExpect(jsonPath("$.customerEmailId").value("Sadvi@gmail.com"))
			.andExpect(jsonPath("$.mobileNo").value(987654320))
			.andDo(print());
			
	}
	
	@Test
	public void testFindCustomerById() throws Exception{
		
		when(customerService.findCustomerById(15)).thenReturn(customer);
		mockMvc.perform(get("/Customer/15")
				.accept(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$.customerId").exists())
		.andExpect(jsonPath("$.customerPassword").exists())
		.andExpect(jsonPath("$.customerName").exists())
		.andExpect(jsonPath("$.customerAddress").exists())
		.andExpect(jsonPath("$.customerEmailId").exists())
		.andExpect(jsonPath("$.mobileNo").exists())
		
		.andExpect(jsonPath("$.customerId").value(15))
		.andExpect(jsonPath("$.customerPassword").value("Naina"))
		.andExpect(jsonPath("$.customerName").value("Nikki"))
		.andExpect(jsonPath("$.customerAddress").value("ShivajiNagar"))
		.andExpect(jsonPath("$.customerEmailId").value("naina@gmail.com"))
		.andExpect(jsonPath("$.mobileNo").value(987654321))
		.andDo(print());
		
	}
	
	@Test
	public void testdeleteCustomer() throws Exception{
		
		when(customerService.findCustomerById(15)).thenReturn(customer);
		
		mockMvc.perform(delete("/Customer/15"))
				
				//.andExpect(jsonPath("$.status").exists())
				.andDo(print())
				.andExpect(status().isOk());
				verify(customerService).deleteCustomer(customer);
				
	}
	
	public void testAuthenticateCustomer() throws Exception{
		Customer customer = new Customer(15, "N@ina", null, null, null, 0);
		when(customerService.AuthenticateCustomer(Mockito.isA(Customer.class))).thenReturn(customer);
		mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON_UTF8))
		
				
	}
	
		
	
}
	

