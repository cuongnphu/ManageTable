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
	public ModelAndView listProducts(@ModelAttribute("tableForm") TableForm tableForm, @PathVariable("table_id") int table_id) {
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
		tableForm.setProductList(listProds);

		// Get all products by table_id
		List<Product> prodList = this.prodService.getAllProductsByTableId(table_id);
		log.info(prodList);

		// Add to modelAttribute of spring-form in ModelView
		model.addObject("tableForm", tableForm);
		model.addObject("prodList", prodList);

		return model;

	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public ModelAndView saveProduct(@ModelAttribute("tableForm") TableForm tableForm) {
		// Get table_id for redirect page
		int table_id = tableForm.getProductList().get(0).getTable_id();

		// Save or Update a product
		try {
			if (this.prodService.getProductById(tableForm.getProductList().get(0).getId()) != null) ;
			log.info("Update a product by id = " + tableForm.getProductList().get(0).getId());
			this.prodService.updateProduct(tableForm.getProductList().get(0));
		} catch (EmptyResultDataAccessException e) {
			log.info("Save a new product !!!");
			this.prodService.saveProduct(tableForm.getProductList().get(0));
		}

		// Initialize variable for redirection page
		RedirectView rv = new RedirectView();
		rv.setContextRelative(true);
		rv.setUrl("/product/" + table_id);

		return new ModelAndView(rv);

	}

	@RequestMapping(value = "/product/{table_id}/edit/{id}")
	public ModelAndView editProduct(@ModelAttribute("tableForm") TableForm tableForm, @PathVariable("id") int id, @PathVariable("table_id") int table_id) {
		// Initialzie a new ModelView
		ModelAndView model = new ModelAndView("edit/edit_products");

        // Declared object orderTable
        OrderTable orderTab = this.orderTableService.getOrderTableById(table_id);

		// Get product by parameter id
		Product prod = this.prodService.getProductById(id);
		List<Product> listProds = new ArrayList<Product>();
		listProds.add(prod);

		// Setter for modelAttribute object
		tableForm.setOrderTable(orderTab);
		tableForm.setProductList(listProds);

		// Get list products by parameter table_id
		List<Product> prodList = this.prodService.getAllProductsByTableId(table_id);

		// Add modelAttribute of spring-form in ModelView
		model.addObject("tableForm", tableForm);
		model.addObject("prodList", prodList);

		return model;
	}

	@RequestMapping(value = "/product/{table_id}/delete/{id}")
	public ModelAndView deleteProduct( @PathVariable("id") int id, @PathVariable("table_id") int table_id) {
		// Delete a product by parameter Id
		log.info("Delete an product by id = " + id);
		this.prodService.deleteProduct(id);

		// Initialize variable for redirection page
		RedirectView rv = new RedirectView();
		rv.setContextRelative(true);
		rv.setUrl("/product/" + table_id);

		return new ModelAndView(rv);
	}

}
