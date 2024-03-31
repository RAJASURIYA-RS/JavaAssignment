package com.service;
import java.sql.SQLException;
import java.util.List;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.model.Customer;

public class CustomerService {

	CustomerDao customerDao = new CustomerDaoImpl();

	public List<Customer> getCustomerDetails() throws SQLException {
		// TODO Auto-generated method stub
		return customerDao.getCustomerDetails();
	}

	public void updateCustomer(int id,String email, String phone, String address) throws SQLException {
		// TODO Auto-generated method stub
		customerDao.updateCustomer(id,email,phone,address);
		
	}
}
