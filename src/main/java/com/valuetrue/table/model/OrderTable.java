package com.valuetrue.table.model;

public class OrderTable {
	
	//Initialize variable column in table
	private Integer id;
	private String name;
	private Integer pre_weight;
	private Integer after_weight;
	
	
	// Initialize Constructor for object OrderTable 
	public OrderTable() {
		this.id = 0;
	}
	
	public OrderTable(Integer id, String name, Integer pre_weight, Integer after_weight) {
		super();
		this.id = id;
		this.name = name;
		this.pre_weight = pre_weight;
		this.after_weight = after_weight;
	}
	
	// Generate getter & setter for id
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	// Generate getter & setter for name
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// Generate getter & setter for pre_weight
	public Integer getPre_weight() {
		return pre_weight;
	}
	
	public void setPre_weight(Integer pre_weight) {
		this.pre_weight = pre_weight;
	}
	
	// Generate getter & setter for after_weight
	public Integer getAfter_weight() {
		return after_weight;
	}
	
	public void setAfter_weight(Integer after_weight) {
		this.after_weight = after_weight;
	}
	
	@Override
	public String toString() {
		return "OrderTable [id=" + id + ", name=" + name + ", pre_weight=" + pre_weight + ", after_weight=" + after_weight + "]";
	}

}
