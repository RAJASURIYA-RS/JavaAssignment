package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.OrderDetailsOfCustomers;
import com.exception.InventoryDetailsNotFound;
import com.exception.OrderNotFoundException;
import com.model.Inventory;

public interface OrdersDao {

	List<OrderDetailsOfCustomers> getOrderDetailsOfCustomer(int cid) throws SQLException;

	OrderDetailsOfCustomers getOrderDetails(int orderId) throws SQLException, OrderNotFoundException;

	void updateQuantityInstock(int productId, int quantity) throws SQLException;

	Inventory getInventoryDetails(int productId) throws SQLException, InventoryDetailsNotFound;

	void deleteOrderDetail(int orderId) throws SQLException;

	void deleteOrder(int orderId) throws SQLException;

}
