package com.valuetrue.table.control;


import com.valuetrue.table.model.Material;
import com.valuetrue.table.service.MaterialServie;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MaterialController {

    private Logger log = Logger.getLogger(MaterialController.class);
    private MaterialServie materialServie;

    @Autowired
    public void setMaterialServie(MaterialServie materialServie) {
        this.materialServie = materialServie;
    }


    @RequestMapping(value = "/edit/material/{table_id}/delete/{id}")
    public ModelAndView deleteMaterial(@PathVariable("id") int id, @PathVariable("table_id") int table_id) {
        // Delete a material by parameter Id
        log.info("Delete an material by id = " + id);
        this.materialServie.deleteMaterial(id);

        // Initialize variable for redirection page
        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("/edit/" + table_id);

        return new ModelAndView(rv);
    }

    @RequestMapping(value = "/addMaterial/{id}", method = RequestMethod.POST)
    public @ResponseBody String addMaterial(@PathVariable("id") int id) {
        // Create a Material with table_id
        Material mate = new Material();
        mate.setTable_id(id);
        mate.setName("");
        mate.setWeight(0f);
        mate.setNum_class(0);
        mate.setQuantity(0);

        // Save material
        this.materialServie.saveMaterial(mate);

        // Redirect to page
        return "/ManageTable/edit/"+id  ;
    }

}
