package com.valuetrue.table.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valuetrue.table.dao.OrderTableDAO;
import com.valuetrue.table.model.OrderTable;


@Service
public class OrderTableServiceImpl implements OrderTableService {
	
	private OrderTableDAO orderTableDAO;

	@Autowired
	public void setOrderTableDAO(OrderTableDAO orderTableDAO) {
		this.orderTableDAO = orderTableDAO;
	}

	@Override
	public void saveOrderTable(OrderTable orderTable) {
		if(orderTable.getName()!= ""){
		    orderTable.setPre_weight(1);
		    orderTable.setAfter_weight(1);
            this.orderTableDAO.saveOrderTable(orderTable);
        }
	}

	@Override
	public void updateOrderTable(OrderTable orderTable) {	
		if(orderTable.getName()!= "")
			this.orderTableDAO.updateOrderTable(orderTable);
	}

	@Override
	public void deleteOrderTable(int id) {	
		this.orderTableDAO.deleteOrderTable(id);
	}

	@Override
	public OrderTable getOrderTableById(int id) {	
		if(id != 0)
			return this.orderTableDAO.getOrderTableById(id);
		else
			return this.orderTableDAO.getOrderTableById(0);
	}

	@Override
	public List<OrderTable> getAllOrderTables() {		
		return this.orderTableDAO.getAllOrderTables();
	}

}
