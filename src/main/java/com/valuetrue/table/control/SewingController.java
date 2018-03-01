package com.valuetrue.table.control;

import com.valuetrue.table.model.OrderTable;
import com.valuetrue.table.model.Sewing;
import com.valuetrue.table.model.TableForm;
import com.valuetrue.table.service.OrderTableService;
import com.valuetrue.table.service.SewingService;
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
@RequestMapping(value = "/sewing")
public class SewingController {

    private Logger log = Logger.getLogger(SewingController.class);
    private OrderTableService orderTableService;
    private SewingService sewingService;

    @Autowired
    public void setOrderTableService(OrderTableService orderTableService) {
        this.orderTableService = orderTableService;
    }

    @Autowired
    public void setSewingService(SewingService sewingService) {
        this.sewingService = sewingService;
    }

    @RequestMapping(value = "/{table_id}")
    public ModelAndView listSewings(@ModelAttribute("tableForm") TableForm tableForm, @PathVariable("table_id") int table_id) {
        // Initialize a new ModelView
        ModelAndView model = new ModelAndView("views/sewings");

        // Declared object orderTable
        OrderTable orderTab = this.orderTableService.getOrderTableById(table_id);

        // Declared List object Sewing
        Sewing sew = new Sewing();
        sew.setTable_id(table_id);
        List<Sewing> formSewingList = new ArrayList<Sewing>();
        formSewingList.add(sew);

        // Setter for modelAttribute object
        tableForm.setOrderTable(orderTab);
        tableForm.setSewingList(formSewingList);

        // Get object sewingList by table_id
        List<Sewing> objSewingList = this.sewingService.getAllSewingsByTableId(table_id);
        log.info(objSewingList);

        // Add to modelAttribute of spring-form in ModelView
        model.addObject("tableForm", tableForm);
        model.addObject("sewingList", objSewingList);

        return model;

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView saveSewing(@ModelAttribute("tableForm") TableForm tableForm) {
        // Get table_id for redirect page
        int table_id = tableForm.getSewingList().get(0).getTable_id();

        // Save or Update a sewing
        try {
            if (this.sewingService.getSewingById(tableForm.getSewingList().get(0).getId()) != null) ;
            log.info("Update a sewing by id = " + tableForm.getSewingList().get(0).getId());
            this.sewingService.updateSewing( tableForm.getSewingList().get(0) );
        } catch (EmptyResultDataAccessException e) {
            log.info("Save a new sewing !!!");
            this.sewingService.saveSewing( tableForm.getSewingList().get(0));
        }

        // Initialize variable for redirection page
        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("/sewing/" + table_id);

        return new ModelAndView(rv);

    }

    @RequestMapping(value = "/{table_id}/edit/{id}")
    public ModelAndView editSewing(@ModelAttribute("tableForm") TableForm tableForm, @PathVariable("id") int id, @PathVariable("table_id") int table_id) {
        // Initialzie a new ModelView
        ModelAndView model = new ModelAndView("edit/edit_sewings");

        // Declared object orderTable
        OrderTable orderTab = this.orderTableService.getOrderTableById(table_id);

        // Get Sewing by parameter id
        Sewing sew = this.sewingService.getSewingById(id);
        List<Sewing> formSewingList = new ArrayList<Sewing>();
        formSewingList.add(sew);

        // Setter for modelAttribute object
        tableForm.setOrderTable(orderTab);
        tableForm.setSewingList(formSewingList);

        // Get object SewingList by parameter table_id
        List<Sewing> objSewingList = this.sewingService.getAllSewingsByTableId(table_id);

        // Add modelAttribute of spring-form in ModelView
        model.addObject("tableForm", tableForm);
        model.addObject("sewingList", objSewingList);

        return model;
    }

    @RequestMapping(value = "/{table_id}/delete/{id}")
    public ModelAndView deleteEmbroidery(@PathVariable("id") int id, @PathVariable("table_id") int table_id) {
        // Delete a printer by parameter Id
        log.info("Delete an sewing by id = " + id);
        this.sewingService.deleteSewing(id);

        // Initialize variable for redirection page
        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("/sewing/" + table_id);

        return new ModelAndView(rv);
    }

}
