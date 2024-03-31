package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Customer;

public interface CustomerDao {


	List<Customer> getCustomerDetails() throws SQLException;

	public void updateCustomer(int id,String email, String phone, String address) throws SQLException;

	
}
