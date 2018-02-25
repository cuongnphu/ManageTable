package com.valuetrue.table.model;

public class Sewing {

    // Initialize column in table
    private Integer id;
    private String name;
    private Integer table_id;
    private Integer price;
    private Integer quantity;
    private Integer total;

    // Implement constructor
    public Sewing(Integer id, String name, Integer table_id, Integer price, Integer quantity, Integer total) {
        this.id = id;
        this.name = name;
        this.table_id = table_id;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public Sewing() {
        this.id = 0;
    }

    // Implement Getter / Setter
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Sewing [id=" + id + ", name=" + name + ", table_id=" + table_id + ", price=" + price + ", quantity=" + quantity + ", total=" + total + "]";
    }

}
