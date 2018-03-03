package com.valuetrue.table.model;

public class Material {

    // Initialize column in table
    private Integer id;
    private String name;
    private Integer table_id;
    private Float weight;
    private Integer num_class;
    private Integer quantity;

    // Implement constructor
    public Material(Integer id, String name, Integer table_id, Float weight, Integer num_class, Integer quantity) {
        this.id = id;
        this.name = name;
        this.table_id = table_id;
        this.weight = weight;
        this.num_class = num_class;
        this.quantity = quantity;
    }

    public Material() {
        this.id = 0;
    }

    // Getter & Setter
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

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getNum_class() {
        return num_class;
    }

    public void setNum_class(Integer num_class) {
        this.num_class = num_class;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Material [id=" + id + ", name=" + name + ", table_id=" + table_id + ", weight=" + weight + ", num_class=" + num_class + ", quantity=" + quantity + "]";
    }

}
