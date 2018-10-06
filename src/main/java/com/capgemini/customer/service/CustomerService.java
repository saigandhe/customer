package com.capgemini.customer.service;

import com.capgemini.customer.exception.CustomerNotFoundException;
import com.capgemini.customer.exception.FailedtoAuthenticateException;
import com.capgemini.customer.model.Customer;

public interface CustomerService {

	public Customer AuthenticateCustomer(Customer customer) throws CustomerNotFoundException, FailedtoAuthenticateException;
	public Customer addCustomer(Customer customer);
	public Customer findCustomerById(int customerId)throws CustomerNotFoundException;
	public Customer updateCustomer(Customer customer); 
	public void deleteCustomer(Customer customer);
	public boolean  updatePassword(Customer customer, String oldPassword, String newPassword);
}

