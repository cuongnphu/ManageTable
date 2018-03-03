package com.valuetrue.table.model;


import java.util.List;



public class TableForm {

	// Initialize variable for model
	private OrderTable orderTable;
	private List<Product> productList;
	private List<Printer> printerList;
	private List<Embroidery> embroideryList;
	private List<Sewing> sewingList;
	private List<Material> materialList;

	// Getter & Setter
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

	public List<Sewing> getSewingList() {
		return sewingList;
	}

	public void setSewingList(List<Sewing> sewingList) {
		this.sewingList = sewingList;
	}

	public List<Material> getMaterialList() {
		return materialList;
	}

	public void setMaterialList(List<Material> materialList) {
		this.materialList = materialList;
	}


}
