package com.valuetrue.table.control;

import java.util.ArrayList;
import java.util.List;

import com.valuetrue.table.model.Product;
import com.valuetrue.table.model.TableForm;
import com.valuetrue.table.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.valuetrue.table.model.OrderTable;
import com.valuetrue.table.service.OrderTableService;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class OrderTableController {
	
	private Logger log = Logger.getLogger(OrderTableController.class);
	private OrderTableService orderTableService;
    private ProductService prodService;

	@Autowired
	public void setOrderTableService(OrderTableService orderTableService) {
		this.orderTableService = orderTableService;
	}

    @Autowired
    public void setProdService(ProductService prodService) {
        this.prodService = prodService;
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

    @RequestMapping(value = "/InfoDetail",method=RequestMethod.POST)
    public ModelAndView saveInfoDetail (@ModelAttribute("tableForm") TableForm tableForm) {
        // Get table_id for redirect page
//        int table_id = tableForm.getProductList().get(0).getTable_id();

        // Save or Update a product
        try {
            if (this.prodService.getProductById(tableForm.getProductList().get(0).getId()) != null) ;
            log.info("Update a product by id = " + tableForm.getProductList().get(0).getId());
            this.prodService.updateProduct(tableForm.getProductList().get(0));
        } catch (EmptyResultDataAccessException e) {
            log.info("Save a new product !!!");
            this.prodService.saveProduct(tableForm.getProductList().get(0));
        }

        try{
            if(this.orderTableService.getOrderTableById(tableForm.getOrderTable().getId()) != null);
            log.info("Update a orderTable by id = " + tableForm.getOrderTable().getId() );
            this.orderTableService.updateOrderTable(tableForm.getOrderTable());
        }catch(EmptyResultDataAccessException e){
            log.info("Save a new orderTable !!!");
            this.orderTableService.saveOrderTable(tableForm.getOrderTable());
        }

        return new ModelAndView("redirect:/tables");
    }

	@RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
	public ModelAndView editOrderTable (@ModelAttribute("tableForm") TableForm tableForm , @PathVariable("id") int id) {
		// Initilaize a new Model
		ModelAndView model = new ModelAndView("edit/edit_tables");

        // Declared object orderTable
        OrderTable orderTab = this.orderTableService.getOrderTableById(id);

        // Get all products by table_id
        List<Product> prodList = this.prodService.getAllProductsByTableId(id);
        log.info(prodList);

        // Declared List object products
        Product prod = new Product();
        prod.setTable_id(id);
        List<Product> listProds = new ArrayList<Product>();
        listProds.add(prod);

        // Setter for modelAttribute object
        tableForm.setOrderTable(orderTab);
        if(prodList.size() > 0)
            tableForm.setProductList(prodList);
        else
            tableForm.setProductList(listProds);

        // Get all orderTable
		List<OrderTable> orderTableList = this.orderTableService.getAllOrderTables();
		
		model.addObject("tableForm", tableForm);
		model.addObject("orderTableList",orderTableList);
		
		return model;
	}
	
	@RequestMapping(value = "/delete/{id}")
	public ModelAndView deleteOrderTable ( @PathVariable("id") int id) {
		log.info("Delete an orderTable by id = " + id );
		this.orderTableService.deleteOrderTable(id);
		
		return new ModelAndView("redirect:/tables");
	}

    @RequestMapping(value = "/addproduct/{id}", method = RequestMethod.POST)
    public  ModelAndView addProduct(@PathVariable("id") int id) {
        // Initilaize a new Model
        ModelAndView model = new ModelAndView("edit/edit_tables");


        log.info("==================\n \n ========================== \n \n");
        // Declared List object products
        Product prod = new Product();
        prod.setTable_id(id);
        prod.setName("");
        prod.setQuantity(0);

        this.prodService.saveProduct(prod);

        // Initialize variable for redirection page
        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("");

//        model.addObject("redirectUrl","/edit/"+id);
        return new ModelAndView(rv);

//        return new ModelAndView("redirect:/tables");

    }

}
