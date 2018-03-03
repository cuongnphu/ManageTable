package com.valuetrue.table.control;


import com.valuetrue.table.model.Material;
import com.valuetrue.table.model.OrderTable;
import com.valuetrue.table.model.TableForm;
import com.valuetrue.table.service.MaterialServie;
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
@RequestMapping(value = "/material")
public class MaterialController {

    private Logger log = Logger.getLogger(MaterialController.class);
    private OrderTableService orderTableService;
    private MaterialServie materialServie;

    @Autowired
    public void setOrderTableService(OrderTableService orderTableService) {
        this.orderTableService = orderTableService;
    }

    @Autowired
    public void setMaterialServie(MaterialServie materialServie) {
        this.materialServie = materialServie;
    }

    @RequestMapping(value = "/{table_id}")
    public ModelAndView listMaterials(@ModelAttribute("tableForm") TableForm tableForm, @PathVariable("table_id") int table_id) {
        // Initialize a new ModelView
        ModelAndView model = new ModelAndView("views/materials");

        // Declared object orderTable
        OrderTable orderTab = this.orderTableService.getOrderTableById(table_id);

        // Declared List object material
        Material material = new Material();
        material.setTable_id(table_id);
        List<Material> formMaterialList = new ArrayList<Material>();
        formMaterialList.add(material);

        // Setter for modelAttribute object
        tableForm.setOrderTable(orderTab);
        tableForm.setMaterialList(formMaterialList);

        // Get object materialList by table_id
        List<Material> objMaterialList = this.materialServie.getAllMaterialsByTableId(table_id);
        log.info(objMaterialList);

        // Add to modelAttribute of spring-form in ModelView
        model.addObject("tableForm", tableForm);
        model.addObject("materialList", objMaterialList);

        return model;

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView saveSewing(@ModelAttribute("tableForm") TableForm tableForm) {
        // Get table_id for redirect page
        int table_id = tableForm.getMaterialList().get(0).getTable_id();

        // Save or Update a material
        try {
            if (this.materialServie.getMaterialById(tableForm.getMaterialList().get(0).getId()) != null) ;
            log.info("Update a material by id = " + tableForm.getMaterialList().get(0).getId());
            this.materialServie.updateMaterial( tableForm.getMaterialList().get(0) );
        } catch (EmptyResultDataAccessException e) {
            log.info("Save a new material !!!");
            this.materialServie.saveMaterial( tableForm.getMaterialList().get(0));
        }

        // Initialize variable for redirection page
        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("/material/" + table_id);

        return new ModelAndView(rv);

    }

    @RequestMapping(value = "/{table_id}/edit/{id}")
    public ModelAndView editSewing(@ModelAttribute("tableForm") TableForm tableForm, @PathVariable("id") int id, @PathVariable("table_id") int table_id) {
        // Initialzie a new ModelView
        ModelAndView model = new ModelAndView("edit/edit_materials");

        // Declared object orderTable
        OrderTable orderTab = this.orderTableService.getOrderTableById(table_id);

        // Get Material by parameter id
        Material material = this.materialServie.getMaterialById(id);
        List<Material> formMaterialList = new ArrayList<Material>();
        formMaterialList.add(material);

        // Setter for modelAttribute object
        tableForm.setOrderTable(orderTab);
        tableForm.setMaterialList(formMaterialList);

        // Get object MaterialList by parameter table_id
        List<Material> objMaterialList = this.materialServie.getAllMaterialsByTableId(table_id);

        // Add modelAttribute of spring-form in ModelView
        model.addObject("tableForm", tableForm);
        model.addObject("materialList", objMaterialList);

        return model;
    }

    @RequestMapping(value = "/{table_id}/delete/{id}")
    public ModelAndView deleteEmbroidery(@PathVariable("id") int id, @PathVariable("table_id") int table_id) {
        // Delete a printer by parameter Id
        log.info("Delete an material by id = " + id);
        this.materialServie.deleteMaterial(id);

        // Initialize variable for redirection page
        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("/material/" + table_id);

        return new ModelAndView(rv);
    }

}
