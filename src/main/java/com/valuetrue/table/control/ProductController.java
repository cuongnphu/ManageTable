package com.valuetrue.table.control;

import java.util.ArrayList;
import java.util.List;

import com.valuetrue.table.service.OrderTableService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.valuetrue.table.model.OrderTable;
import com.valuetrue.table.model.Product;
import com.valuetrue.table.model.TableForm;
import com.valuetrue.table.service.ProductService;


@Controller
public class ProductController {

	private Logger log = Logger.getLogger(ProductController.class);
	private ProductService prodService;
	private OrderTableService orderTableService;

	@Autowired
	public void setOrderTableService(OrderTableService orderTableService) {
		this.orderTableService = orderTableService;
	}

	@Autowired
	public void setProdService(ProductService prodService) {
		this.prodService = prodService;
	}


	@RequestMapping(value = "/product/{table_id}")
	public ModelAndView addInformationTable(@ModelAttribute("tableForm") TableForm tableForm, @PathVariable("table_id") int table_id) {
		// Initialize a new ModelView
		ModelAndView model = new ModelAndView("views/products");

		// Declared object orderTable
		OrderTable orderTab = this.orderTableService.getOrderTableById(table_id);

		// Declared List object products
		Product prod = new Product();
		prod.setTable_id(table_id);
		List<Product> listProds = new ArrayList<Product>();
		listProds.add(prod);

		// Setter for modelAttribute object
		tableForm.setOrderTable(orderTab);
		tableForm.setProds(listProds);

		// Get all products by table_id
		List<Product> prodList = this.prodService.getAllProductsByTableId(table_id);
		log.info(prodList);

		// Add to modelAttribute of spring-form in ModelView
		model.addObject("tableForm", tableForm);
		model.addObject("prodList", prodList);

		return model;

	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public ModelAndView saveInformationTable(@ModelAttribute("tableForm") TableForm tableForm) {

		int table_id = tableForm.getProds().get(0).getTable_id();
		try {
			if (this.prodService.getProductById(tableForm.getProds().get(0).getId()) != null)
				;
			log.info("Update a infoTable by id = " + tableForm.getProds().get(0).getId());
			this.prodService.updateProduct(tableForm.getProds().get(0));
		} catch (EmptyResultDataAccessException e) {
			log.info("Save a new infoTable !!!");
			this.prodService.saveProduct(tableForm.getProds().get(0));
		}
		RedirectView rv = new RedirectView();
		rv.setContextRelative(true);
		rv.setUrl("/product/" + table_id);

		return new ModelAndView(rv);

	}

	@RequestMapping(value = "/infotable/{table_id}/edit/{id}")
	public ModelAndView editInformationTable(@ModelAttribute("tableForm") TableForm tableForm,
			@PathVariable("id") int id, @PathVariable("table_id") int table_id) {
		ModelAndView model = new ModelAndView("views/products");

		Product prod = this.prodService.getProductById(id);
		List<Product> listProds = new ArrayList<Product>();
		listProds.add(prod);
		tableForm.setProds(listProds);

		List<Product> prodList = this.prodService.getAllProductsByTableId(table_id);

		model.addObject("tableForm", tableForm);
		model.addObject("prodList", prodList);

		return model;
	}

	@RequestMapping(value = "/infotable/{table_id}/delete/{id}")
	public ModelAndView deleteOrderTable(@ModelAttribute("modeltable") OrderTable orderTable,
			@PathVariable("id") int id, @PathVariable("table_id") int table_id) {
		
		log.info("Delete an product by id = " + id);
		this.prodService.deleteProduct(id);

		RedirectView rv = new RedirectView();
		rv.setContextRelative(true);
		rv.setUrl("/infotable/" + table_id);

		return new ModelAndView(rv);
	}

}
