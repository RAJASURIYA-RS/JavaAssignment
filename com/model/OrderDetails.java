package com.model;

public class OrderDetails {
	private int id;
	private double quantity;
	private int productId;
	private int orderId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public OrderDetails(int id, double quantity, int productId, int orderId) {
		this.id = id;
		this.quantity = quantity;
		this.productId = productId;
		this.orderId = orderId;
	}

	public OrderDetails(double quantity, int productId, int orderId) {
		this.quantity = quantity;
		this.productId = productId;
		this.orderId = orderId;
	}

	public OrderDetails() {
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", quantity=" + quantity + ", productId=" + productId + ", orderId=" + orderId
				+ "]";
	}

}
