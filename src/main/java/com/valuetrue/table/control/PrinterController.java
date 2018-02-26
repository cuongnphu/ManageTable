package com.valuetrue.table.control;


import com.valuetrue.table.model.OrderTable;
import com.valuetrue.table.model.Printer;
import com.valuetrue.table.model.TableForm;
import com.valuetrue.table.service.OrderTableService;
import com.valuetrue.table.service.PrinterService;
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
public class PrinterController {

    private Logger log = Logger.getLogger(ProductController.class);
    private PrinterService printerService;
    private OrderTableService orderTableService;

    @Autowired
    public void setOrderTableService(OrderTableService orderTableService) {
        this.orderTableService = orderTableService;
    }

    @Autowired
    public void setPrinterService(PrinterService printerService) {
        this.printerService = printerService;
    }


    @RequestMapping(value = "/printer/{table_id}")
    public ModelAndView addInformationTable(@ModelAttribute("tableForm") TableForm tableForm, @PathVariable("table_id") int table_id) {
        // Initialize a new ModelView
        ModelAndView model = new ModelAndView("views/printers");

        // Declared object orderTable
        OrderTable orderTab = this.orderTableService.getOrderTableById(table_id);

        // Declared List object printer
        Printer print = new Printer();
        print.setTable_id(table_id);
        List<Printer> formPrinterList = new ArrayList<Printer>();
        formPrinterList.add(print);

        // Setter for modelAttribute object
        tableForm.setOrderTable(orderTab);
        tableForm.setPrinterList(formPrinterList);

        // Get object printerList by table_id
        List<Printer> objPrinterList = this.printerService.getAllPrintersByTableId(table_id);
        log.info(objPrinterList);

        // Add to modelAttribute of spring-form in ModelView
        model.addObject("tableForm", tableForm);
        model.addObject("printerList", objPrinterList);

        return model;

    }

    @RequestMapping(value = "/printer", method = RequestMethod.POST)
    public ModelAndView saveInformationTable(@ModelAttribute("tableForm") TableForm tableForm) {
        // Get table_id for redirect page
        int table_id = tableForm.getPrinterList().get(0).getTable_id();

        Printer print = tableForm.getPrinterList().get(0);
        Integer total = tableForm.getPrinterList().get(0).getPrice()* tableForm.getPrinterList().get(0).getQuantity();
        print.setTotal(total);

        // Save or Update a printer
        try {
            if (this.printerService.getPrinterById(tableForm.getPrinterList().get(0).getId()) != null) ;
            log.info("Update a printer by id = " + tableForm.getPrinterList().get(0).getId());
            this.printerService.updatePrinter( tableForm.getPrinterList().get(0));
        } catch (EmptyResultDataAccessException e) {
            log.info("Save a new printer !!!");
            this.printerService.savePrinter( tableForm.getPrinterList().get(0));
        }

        // Initialize variable for redirection page
        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("/printer/" + table_id);

        return new ModelAndView(rv);

    }

    @RequestMapping(value = "/printer/{table_id}/edit/{id}")
    public ModelAndView editInformationTable(@ModelAttribute("tableForm") TableForm tableForm, @PathVariable("id") int id, @PathVariable("table_id") int table_id) {
        // Initialzie a new ModelView
        ModelAndView model = new ModelAndView("edit/edit_products");

        // Declared object orderTable
        OrderTable orderTab = this.orderTableService.getOrderTableById(table_id);

        // Get Printer by parameter id
        Printer print = this.printerService.getPrinterById(id);
        List<Printer> formPrinterList = new ArrayList<Printer>();
        formPrinterList.add(print);

        // Setter for modelAttribute object
        tableForm.setOrderTable(orderTab);
        tableForm.setPrinterList(formPrinterList);

        // Get object PrinterList by parameter table_id
        List<Printer> objPrinterList = this.printerService.getAllPrintersByTableId(table_id);

        // Add modelAttribute of spring-form in ModelView
        model.addObject("tableForm", tableForm);
        model.addObject("printerList", objPrinterList);

        return model;
    }

    @RequestMapping(value = "/printer/{table_id}/delete/{id}")
    public ModelAndView deleteOrderTable(@ModelAttribute("modeltable") OrderTable orderTable, @PathVariable("id") int id, @PathVariable("table_id") int table_id) {
        // Delete a printer by parameter Id
        log.info("Delete an product by id = " + id);
        this.printerService.deletePrinter(id);

        // Initialize variable for redirection page
        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("/printer/" + table_id);

        return new ModelAndView(rv);
    }


}
