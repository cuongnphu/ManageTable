package com.valuetrue.table.model;

public class Product {
	
	// Initialize variable column in table
	private Integer id;
	private String name;
	private Integer table_id;
	private Integer quantity;

	// Implement for Constructor
	public Product(Integer id, String name, Integer table_id, Integer quantity) {
		super();
		this.id = id;
		this.name = name;
		this.table_id = table_id;
		this.quantity = quantity;
	}

	public Product() {
		this.id = 0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTable_id() {
		return table_id;
	}

	public void setTable_id(Integer table_id) {
		this.table_id = table_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", table_id=" + table_id + ", quantity=" + quantity + "]";
	}

}
