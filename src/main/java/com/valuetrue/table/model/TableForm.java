package com.valuetrue.table.model;


import java.util.List;



public class TableForm {

	private OrderTable orderTable;
	private List<Product> productList;
	private List<Printer> printerList;
	private List<Embroidery> embroideryList;


	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public List<Printer> getPrinterList() {
		return printerList;
	}

	public void setPrinterList(List<Printer> printerList) {
		this.printerList = printerList;
	}

	public OrderTable getOrderTable() {
		return orderTable;
	}

	public void setOrderTable(OrderTable orderTable) {
		this.orderTable = orderTable;
	}

	public List<Embroidery> getEmbroideryList() {
		return embroideryList;
	}

	public void setEmbroideryList(List<Embroidery> embroideryList) {
		this.embroideryList = embroideryList;
	}


}
