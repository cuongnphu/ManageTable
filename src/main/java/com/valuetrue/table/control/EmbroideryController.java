package com.valuetrue.table.control;

import com.valuetrue.table.model.Embroidery;
import com.valuetrue.table.service.EmbroideryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class EmbroideryController {

    private Logger log = Logger.getLogger(ProductController.class);
    private EmbroideryService embroideryService;

    @Autowired
    public void setEmbroideryService(EmbroideryService embroideryService) {
        this.embroideryService = embroideryService;
    }

    @RequestMapping(value = "/edit/embroidery/{table_id}/delete/{id}")
    public ModelAndView deleteEmbroidery(@PathVariable("id") int id, @PathVariable("table_id") int table_id) {
        // Delete a embroidery by parameter Id
        log.info("Delete an embroidery by id = " + id);
        this.embroideryService.deleteEmbroidery(id);

        // Initialize variable for redirection page
        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("/edit/" + table_id);

        return new ModelAndView(rv);
    }

    @RequestMapping(value = "/addEmbroidery/{id}", method = RequestMethod.POST)
    public @ResponseBody String addEmbroidery(@PathVariable("id") int id) {
        // Create a embroidery with table_id
        Embroidery embroidery = new Embroidery();
        embroidery.setTable_id(id);
        embroidery.setName("");
        embroidery.setPrice(0);
        embroidery.setQuantity(0);

        // Save printer
        this.embroideryService.saveEmbroidery(embroidery);

        // Redirect to page
        return "/ManageTable/edit/"+id  ;
    }


}
