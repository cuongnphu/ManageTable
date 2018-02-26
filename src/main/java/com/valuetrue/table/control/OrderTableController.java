package com.valuetrue.table.control;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.valuetrue.table.model.OrderTable;
import com.valuetrue.table.service.OrderTableService;



@Controller
public class OrderTableController {
	
	private Logger log = Logger.getLogger(OrderTableController.class);
	private OrderTableService orderTableService;

	@Autowired
	public void setOrderTableService(OrderTableService orderTableService) {
		this.orderTableService = orderTableService;
	}

	@RequestMapping(value="/tables", method = RequestMethod.GET)
	public ModelAndView listOrderTables (@ModelAttribute("modeltable") OrderTable orderTable) {
		ModelAndView model = new ModelAndView("views/tables");
		
        List<OrderTable> orderTableList = this.orderTableService.getAllOrderTables();
        log.info(orderTableList);
        model.addObject("orderTableList", orderTableList);    
        
        return model;
	}
	
	@RequestMapping(value = "/table",method=RequestMethod.POST)
    public ModelAndView saveOrderTable (@ModelAttribute("modeltable") OrderTable orderTable) {
        try{   	
            if(this.orderTableService.getOrderTableById(orderTable.getId()) != null);
            log.info("Update a orderTable by id = " + orderTable.getId() );
            this.orderTableService.updateOrderTable(orderTable);
        }catch(EmptyResultDataAccessException e){
            log.info("Save a new orderTable !!!");
            this.orderTableService.saveOrderTable(orderTable);
        }
        
        return new ModelAndView("redirect:/tables");
    }
	
	@RequestMapping(value = "/edit/{id}")
	public ModelAndView editOrderTable (@ModelAttribute("modeltable") OrderTable orderTable , @PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("edit/edit_tables");
		
		orderTable = this.orderTableService.getOrderTableById(id);
		List<OrderTable> orderTableList = this.orderTableService.getAllOrderTables();
		
		model.addObject("modeltable", orderTable);
		model.addObject("orderTableList",orderTableList);
		
		return model;
	}
	
	@RequestMapping(value = "/delete/{id}")
	public ModelAndView deleteOrderTable ( @PathVariable("id") int id) {
		log.info("Delete an orderTable by id = " + id );
		this.orderTableService.deleteOrderTable(id);
		
		return new ModelAndView("redirect:/tables");
	}

}
