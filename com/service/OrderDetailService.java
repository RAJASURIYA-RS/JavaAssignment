package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.OrderDetailDao;
import com.dao.OrderDetailDaoImpl;
import com.dto.OrderDetailsOfCustomers;
import com.exception.ProductNotFoundException;
import com.model.Product;

public class OrderDetailService {
	OrderDetailDao orderDetailDao=new OrderDetailDaoImpl();
	
	public List<OrderDetailsOfCustomers> getOrderDetail( int cid) throws SQLException{
		
		return orderDetailDao.getOrderDetail(cid);
		
	}

	public double getTotalAmount(List<OrderDetailsOfCustomers> list) {
		double totalAmount=0;
		for (OrderDetailsOfCustomers o:list) {
			totalAmount+=o.getTotalAmount();
		}
		return totalAmount;
	}

	public void updateQuantity(int orderId, int quantity) throws SQLException {
		orderDetailDao.updateQuantity(orderId,quantity);
	}

	public void updateDiscount(int productId, double discount) throws SQLException {
		orderDetailDao.updateDiscount(productId,discount);
	}

	public Product getPrice(int productId) throws SQLException, ProductNotFoundException {

		return orderDetailDao.getPrice(productId);
	}
}
