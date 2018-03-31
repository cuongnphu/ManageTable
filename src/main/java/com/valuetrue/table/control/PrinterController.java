package com.valuetrue.table.control;


import com.valuetrue.table.model.Printer;
import com.valuetrue.table.service.PrinterService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class PrinterController {

    private Logger log = Logger.getLogger(ProductController.class);
    private PrinterService printerService;

    @Autowired
    public void setPrinterService(PrinterService printerService) {
        this.printerService = printerService;
    }

    @RequestMapping(value = "/edit/printer/{table_id}/delete/{id}")
    public ModelAndView deletePrinter(@PathVariable("id") int id, @PathVariable("table_id") int table_id) {
        // Delete a printer by parameter Id
        log.info("Delete an printer by id = " + id);
        this.printerService.deletePrinter(id);

        // Initialize variable for redirection page
        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("/edit/" + table_id);

        return new ModelAndView(rv);
    }

    @RequestMapping(value = "/addprinter/{id}", method = RequestMethod.POST)
    public @ResponseBody String addPrinter(@PathVariable("id") int id) {
        // Create a printer with table_id
        Printer print = new Printer();
        print.setTable_id(id);
        print.setName("");
        print.setPrice(0);
        print.setQuantity(0);

        // Save printer
        this.printerService.savePrinter(print);

        // Redirect to page
        return "/ManageTable/edit/"+id  ;
    }

}
