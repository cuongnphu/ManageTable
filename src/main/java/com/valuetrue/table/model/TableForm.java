package com.valuetrue.table.model;


import java.util.List;



public class TableForm {


	private OrderTable orderTable;
	private List<Product> prods;

	public OrderTable getOrderTable() {
		return orderTable;
	}

	public void setOrderTable(OrderTable orderTable) {
		this.orderTable = orderTable;
	}

	public List<Product> getProds() {
		return prods;
	}
	public void setProds(List<Product> prods) {
		this.prods = prods;
	}

}
