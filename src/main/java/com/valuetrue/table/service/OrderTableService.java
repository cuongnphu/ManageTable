package com.valuetrue.table.service;

import java.util.List;

import com.valuetrue.table.model.OrderTable;


public interface OrderTableService {

	public void saveOrderTable(OrderTable orderTable);
	public void updateOrderTable(OrderTable orderTable);
	public void deleteOrderTable(int id);
	public OrderTable getOrderTableById(int id);
	public List<OrderTable> getAllOrderTables();
}
