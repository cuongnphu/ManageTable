package com.valuetrue.table.control;

import com.valuetrue.table.model.Embroidery;
import com.valuetrue.table.model.OrderTable;
import com.valuetrue.table.model.TableForm;
import com.valuetrue.table.service.EmbroideryService;
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

import java.util.ArrayList;
import java.util.List;


@Controller
public class EmbroideryController {

    private Logger log = Logger.getLogger(ProductController.class);
    private EmbroideryService embroideryService;
    private OrderTableService orderTableService;

    @Autowired
    public void setOrderTableService(OrderTableService orderTableService) {
        this.orderTableService = orderTableService;
    }

    @Autowired
    public void setEmbroideryService(EmbroideryService embroideryService) {
        this.embroideryService = embroideryService;
    }


    @RequestMapping(value = "/embroidery/{table_id}")
    public ModelAndView listEmbroideries(@ModelAttribute("tableForm") TableForm tableForm, @PathVariable("table_id") int table_id) {
        // Initialize a new ModelView
        ModelAndView model = new ModelAndView("views/embroideries");

        // Declared object orderTable
        OrderTable orderTab = this.orderTableService.getOrderTableById(table_id);

        // Declared List object embroidery
        Embroidery emb = new Embroidery();
        emb.setTable_id(table_id);
        List<Embroidery> formEmbroideryList = new ArrayList<Embroidery>();
        formEmbroideryList.add(emb);

        // Setter for modelAttribute object
        tableForm.setOrderTable(orderTab);
        tableForm.setEmbroideryList(formEmbroideryList);

        // Get object printerList by table_id
        List<Embroidery> objEmbroideryList = this.embroideryService.getAllEmbroideriesByTableId(table_id);
        log.info(objEmbroideryList);

        // Add to modelAttribute of spring-form in ModelView
        model.addObject("tableForm", tableForm);
        model.addObject("embroideryList", objEmbroideryList);

        return model;

    }

    @RequestMapping(value = "/embroidery", method = RequestMethod.POST)
    public ModelAndView saveEmbroidery(@ModelAttribute("tableForm") TableForm tableForm) {
        // Get table_id for redirect page
        int table_id = tableForm.getEmbroideryList().get(0).getTable_id();

        // Save or Update a embroidery
        try {
            if (this.embroideryService.getEmbroideryById(tableForm.getEmbroideryList().get(0).getId()) != null) ;
            log.info("Update a embroidery by id = " + tableForm.getEmbroideryList().get(0).getId());
            this.embroideryService.updateEmbroidery( tableForm.getEmbroideryList().get(0) );
        } catch (EmptyResultDataAccessException e) {
            log.info("Save a new embroidery !!!");
            this.embroideryService.saveEmbroidery( tableForm.getEmbroideryList().get(0));
        }

        // Initialize variable for redirection page
        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("/embroidery/" + table_id);

        return new ModelAndView(rv);

    }

    @RequestMapping(value = "/embroidery/{table_id}/edit/{id}")
    public ModelAndView editEmbroidery(@ModelAttribute("tableForm") TableForm tableForm, @PathVariable("id") int id, @PathVariable("table_id") int table_id) {
        // Initialzie a new ModelView
        ModelAndView model = new ModelAndView("edit/edit_embroideries");

        // Declared object orderTable
        OrderTable orderTab = this.orderTableService.getOrderTableById(table_id);

        // Get Embroidery by parameter id
        Embroidery emb = this.embroideryService.getEmbroideryById(id);
        List<Embroidery> formEmbroideryList = new ArrayList<Embroidery>();
        formEmbroideryList.add(emb);

        // Setter for modelAttribute object
        tableForm.setOrderTable(orderTab);
        tableForm.setEmbroideryList(formEmbroideryList);

        // Get object EmbroideryList by parameter table_id
        List<Embroidery> objEmbroideryList = this.embroideryService.getAllEmbroideriesByTableId(table_id);

        // Add modelAttribute of spring-form in ModelView
        model.addObject("tableForm", tableForm);
        model.addObject("embroideryList", objEmbroideryList);

        return model;
    }

    @RequestMapping(value = "/embroidery/{table_id}/delete/{id}")
    public ModelAndView deleteEmbroidery(@PathVariable("id") int id, @PathVariable("table_id") int table_id) {
        // Delete a printer by parameter Id
        log.info("Delete an embroidery by id = " + id);
        this.embroideryService.deleteEmbroidery(id);

        // Initialize variable for redirection page
        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("/embroidery/" + table_id);

        return new ModelAndView(rv);
    }


}
