package com.valuetrue.table.control;

import java.util.ArrayList;
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
import org.springframework.web.servlet.view.RedirectView;

import com.valuetrue.table.model.OrderTable;
import com.valuetrue.table.model.Product;
import com.valuetrue.table.model.TableForm;
import com.valuetrue.table.service.ProductService;

@Controller
public class InfoTableController {

	private Logger log = Logger.getLogger(InfoTableController.class);
	private ProductService prodService;

	@Autowired
	public void setProdService(ProductService prodService) {
		this.prodService = prodService;
	}

	@RequestMapping(value = "/information", method = RequestMethod.GET)
	public ModelAndView listInformationTables(@ModelAttribute("tableForm") TableForm tableForm) {
		ModelAndView model = new ModelAndView("information");

		List<Product> prodList = this.prodService.getAllProducts();
		log.info(prodList);
		model.addObject("prodList", prodList);

		return model;
	}

	@RequestMapping(value = "/infotable/{table_id}")
	public ModelAndView addInformationTable(@ModelAttribute("tableForm") TableForm tableForm,
			@PathVariable("table_id") int table_id) {
		ModelAndView model = new ModelAndView("information");

		Product prod = new Product();
		prod.setTable_id(table_id);
		List<Product> listProds = new ArrayList<Product>();
		listProds.add(prod);
		tableForm.setProds(listProds);

		List<Product> prodList = this.prodService.getAllProductsByTableId(table_id);
		log.info(prodList);

		model.addObject("tableForm", tableForm);
		model.addObject("prodList", prodList);

		return model;

	}

	@RequestMapping(value = "/infotable", method = RequestMethod.POST)
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
		rv.setUrl("/infotable/" + table_id);

		return new ModelAndView(rv);

	}

	@RequestMapping(value = "/infotable/{table_id}/edit/{id}")
	public ModelAndView editInformationTable(@ModelAttribute("tableForm") TableForm tableForm,
			@PathVariable("id") int id, @PathVariable("table_id") int table_id) {
		ModelAndView model = new ModelAndView("information");

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
