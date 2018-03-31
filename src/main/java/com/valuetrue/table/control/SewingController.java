package com.valuetrue.table.control;

import com.valuetrue.table.model.Sewing;
import com.valuetrue.table.service.SewingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class SewingController {

    private Logger log = Logger.getLogger(SewingController.class);
    private SewingService sewingService;

    @Autowired
    public void setSewingService(SewingService sewingService) {
        this.sewingService = sewingService;
    }


    @RequestMapping(value = "/edit/sewing/{table_id}/delete/{id}")
    public ModelAndView deleteSewing(@PathVariable("id") int id, @PathVariable("table_id") int table_id) {
        // Delete a sewing by parameter Id
        log.info("Delete an sewing by id = " + id);
        this.sewingService.deleteSewing(id);

        // Initialize variable for redirection page
        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("/edit/" + table_id);

        return new ModelAndView(rv);
    }

    @RequestMapping(value = "/addSewing/{id}", method = RequestMethod.POST)
    public @ResponseBody String addSewing(@PathVariable("id") int id) {
        // Create a Sewing with table_id
        Sewing sew = new Sewing();
        sew.setTable_id(id);
        sew.setName("");
        sew.setPrice(0);
        sew.setQuantity(0);

        // Save sewing
        this.sewingService.saveSewing(sew);

        // Redirect to page
        return "/ManageTable/edit/"+id  ;
    }

}
