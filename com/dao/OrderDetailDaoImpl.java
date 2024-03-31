package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.OrderDetailsOfCustomers;
import com.exception.ProductNotFoundException;
import com.model.Product;
import com.util.DBUtil;

public class OrderDetailDaoImpl implements OrderDetailDao{

	@Override
	public List<OrderDetailsOfCustomers> getOrderDetail(int cid) throws SQLException {
		
		Connection conn=DBUtil.getDBConn();
		List<OrderDetailsOfCustomers> list =new ArrayList<OrderDetailsOfCustomers>();
		
		String sql="select od.id,p.name,od.product_id,p.price,o.total_amount,od.quantity from orders_details od join orders o on o.id =od.orders_id join product p on p.id =od.product_id where o.customer_id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, cid);
		ResultSet rst=pstmt.executeQuery();
		while(rst.next()) {
			int orderId=rst.getInt("id");
			String productName=rst.getString("name");
			int productId=rst.getInt("id");
			double totalAmount=rst.getDouble("total_amount");
			int quantity=rst.getInt("quantity");
			double price=rst.getDouble("price");
			OrderDetailsOfCustomers od=new OrderDetailsOfCustomers();
			od.setOrderId(orderId);
			od.setProductName(productName);
			od.setTotalAmount(totalAmount);
			od.setQuantity(quantity);
			od.setProductId(productId);
			od.setPrice(price);
			list.add(od);
			
		}
		
		DBUtil.dbClose();
		
		return list;
	}

	@Override
	public void updateQuantity(int orderId, int quantity) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="update orders_details set quantity=? where orders_id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, quantity);
		pstmt.setInt(2, orderId);
		pstmt.executeUpdate();

		
		DBUtil.dbClose();

	}

	@Override
	public void updateDiscount(int productId,double discount) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="update product set price=? where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setDouble(1, discount);
		pstmt.setInt(2, productId);
		pstmt.executeUpdate();

		
		DBUtil.dbClose();
	}

	@Override
	public Product getPrice(int productId) throws SQLException, ProductNotFoundException {
		Connection conn=DBUtil.getDBConn();
		
		String sql="select * from product where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, productId);
		ResultSet rst=pstmt.executeQuery();
		if(rst.next()) {
			double price=rst.getDouble("price");
			Product p=new Product();
			p.setProductPrice(price);
			return p;
		}
		
		DBUtil.dbClose();
		throw new ProductNotFoundException("Product ID Not Found");
	}

}
