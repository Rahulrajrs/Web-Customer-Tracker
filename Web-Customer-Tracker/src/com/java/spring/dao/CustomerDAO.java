package com.java.spring.dao;

import java.util.List;

import com.java.spring.entity.Customer;

public interface CustomerDAO {
	
	
	public List<Customer> getCustomerDetails();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

}
