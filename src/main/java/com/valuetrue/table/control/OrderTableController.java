package com.valuetrue.table.control;

import java.util.List;

import com.valuetrue.table.model.*;
import com.valuetrue.table.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class OrderTableController {

    private Logger log = Logger.getLogger(OrderTableController.class);
    private OrderTableService orderTableService;
    private ProductService prodService;
    private DetailTableService detailTableService;
    private PrinterService printerService;
    private EmbroideryService embroideryService;
    private SewingService sewingService;
    private MaterialServie materialServie;

    @Autowired
    public void setDetailTableService(DetailTableService detailTableService) {
        this.detailTableService = detailTableService;
    }

    @Autowired
    public void setOrderTableService(OrderTableService orderTableService) {
        this.orderTableService = orderTableService;
    }

    @Autowired
    public void setProdService(ProductService prodService) {
        this.prodService = prodService;
    }

    @Autowired
    public void setPrinterService(PrinterService printerService) {
        this.printerService = printerService;
    }

    @Autowired
    public void setEmbroideryService(EmbroideryService embroideryService) {
        this.embroideryService = embroideryService;
    }

    @Autowired
    public void setSewingService(SewingService sewingService) {
        this.sewingService = sewingService;
    }

    @Autowired
    public void setMaterialServie(MaterialServie materialServie) {
        this.materialServie = materialServie;
    }

    @RequestMapping(value = "/tables", method = RequestMethod.GET)
    public ModelAndView listOrderTables(@ModelAttribute("modeltable") OrderTable orderTable) {
        // Initialize a ModelAndView
        ModelAndView model = new ModelAndView("views/tables");

        // Get all orderTable
        List<TableForm> listTabForm = this.detailTableService.getAllTableForm();

        // Add modelAttribute of spring-form in ModelView
        model.addObject("listTableForm", listTabForm);

        return model;
    }

    @RequestMapping(value = "/table", method = RequestMethod.POST)
    public ModelAndView saveOrderTable(@ModelAttribute("modeltable") OrderTable orderTable) {
        try {
            if (this.orderTableService.getOrderTableById(orderTable.getId()) != null) ;
            this.orderTableService.updateOrderTable(orderTable);
        } catch (EmptyResultDataAccessException e) {
            log.info("Create a new orderTable !!!");
            this.orderTableService.saveOrderTable(orderTable);
        }

        return new ModelAndView("redirect:/tables");
    }

    @RequestMapping(value = "/infodetail", method = RequestMethod.POST)
    public ModelAndView saveInfoDetail(@ModelAttribute("tableForm") TableForm tableForm) {
        // Update orderTable
        try {
            if (this.orderTableService.getOrderTableById(tableForm.getOrderTable().getId()) != null) ;
            log.info("Update a orderTable by id = " + tableForm.getOrderTable().getId());
            this.orderTableService.updateOrderTable(tableForm.getOrderTable());
        } catch (EmptyResultDataAccessException e) {
            this.orderTableService.saveOrderTable(tableForm.getOrderTable());
        }

        // Save or Update product
        if (tableForm.getProductList() != null) {
            for (int i = 0; i < tableForm.getProductList().size(); i++) {
                try {
                    if (this.prodService.getProductById(tableForm.getProductList().get(i).getId()) != null) ;
                    log.info("Update a product by id=" + tableForm.getProductList().get(i).getId());
                    this.prodService.updateProduct(tableForm.getProductList().get(i));
                } catch (EmptyResultDataAccessException e) {
                    log.info("Save a new product !!!");
                    this.prodService.saveProduct(tableForm.getProductList().get(i));
                }
            }
        }

        // Save or Update printer
        if (tableForm.getPrinterList() != null) {
            for (int i = 0; i < tableForm.getPrinterList().size(); i++) {
                try {
                    if (this.printerService.getPrinterById(tableForm.getPrinterList().get(i).getId()) != null) ;
                    log.info("Update a printer by id=" + tableForm.getPrinterList().get(i).getId());
                    this.printerService.updatePrinter(tableForm.getPrinterList().get(i));
                } catch (EmptyResultDataAccessException e) {
                    log.info("Save a new printer !!!");
                    this.printerService.savePrinter(tableForm.getPrinterList().get(i));
                }
            }
        }

        // Save or Update embroidery
        if (tableForm.getEmbroideryList() != null) {
            for (int i = 0; i < tableForm.getPrinterList().size(); i++) {
                try {
                    if (this.embroideryService.getEmbroideryById(tableForm.getEmbroideryList().get(i).getId()) != null)
                        ;
                    log.info("Update a embroidery by id=" + tableForm.getEmbroideryList().get(i).getId());
                    this.embroideryService.updateEmbroidery(tableForm.getEmbroideryList().get(i));
                } catch (EmptyResultDataAccessException e) {
                    log.info("Save a new embroidery !!!");
                    this.embroideryService.saveEmbroidery(tableForm.getEmbroideryList().get(i));
                }
            }
        }

        // Save or Update sewing
        if (tableForm.getSewingList() != null) {
            for (int i = 0; i < tableForm.getSewingList().size(); i++) {
                try {
                    if (this.sewingService.getSewingById(tableForm.getSewingList().get(i).getId()) != null) ;
                    log.info("Update a sewing by id=" + tableForm.getSewingList().get(i).getId());
                    this.sewingService.updateSewing(tableForm.getSewingList().get(i));
                } catch (EmptyResultDataAccessException e) {
                    log.info("Save a new sewing !!!");
                    this.sewingService.saveSewing(tableForm.getSewingList().get(i));
                }
            }
        }

        // Save or Update material
        if (tableForm.getMaterialList() != null) {
            for (int i = 0; i < tableForm.getMaterialList().size(); i++) {
                try {
                    if (this.materialServie.getMaterialById(tableForm.getMaterialList().get(i).getId()) != null) ;
                    log.info("Update a material by id=" + tableForm.getMaterialList().get(i).getId());
                    this.materialServie.updateMaterial(tableForm.getMaterialList().get(i));
                } catch (EmptyResultDataAccessException e) {
                    log.info("Save a new material !!!");
                    this.materialServie.saveMaterial(tableForm.getMaterialList().get(i));
                }
            }
        }

        return new ModelAndView("redirect:/tables");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editOrderTable(@ModelAttribute("tableForm") TableForm tableForm, @PathVariable("id") int id) {
        // Initilaize a new Model
        ModelAndView model = new ModelAndView("edit/edit_tables");

        // Get orderTable by Id
        OrderTable orderTab = this.orderTableService.getOrderTableById(id);

        // Get List products by table_id
        List<Product> productListByTableId = this.prodService.getAllProductsByTableId(id);
        log.info(productListByTableId);

        // Get List Printers by table_id
        List<Printer> printerListByTableId = this.printerService.getAllPrintersByTableId(id);
        log.info(printerListByTableId);

        // Get List Embroideries by table_id
        List<Embroidery> embroideryListByTableId = this.embroideryService.getAllEmbroideriesByTableId(id);
        log.info(embroideryListByTableId);

        // Get List Sewings by table_id
        List<Sewing> sewingListByTableId = this.sewingService.getAllSewingsByTableId(id);
        log.info(sewingListByTableId);

        // Get List Material by table_id
        List<Material> materialListByTableId = this.materialServie.getAllMaterialsByTableId(id);
        log.info(materialListByTableId);

        // Setter for modelAttribute object
        tableForm.setOrderTable(orderTab);
        tableForm.setProductList(productListByTableId);
        tableForm.setPrinterList(printerListByTableId);
        tableForm.setEmbroideryList(embroideryListByTableId);
        tableForm.setSewingList(sewingListByTableId);
        tableForm.setMaterialList(materialListByTableId);

        // Get all orderTable detail
        List<TableForm> listTabForm = this.detailTableService.getAllTableForm();

        model.addObject("tableForm", tableForm);
        model.addObject("listTableForm", listTabForm);

        return model;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView deleteOrderTable(@PathVariable("id") int id) {
        // Get List products by table_id
        List<Product> productListByTableId = this.prodService.getAllProductsByTableId(id);

        // Get List Printers by table_id
        List<Printer> printerListByTableId = this.printerService.getAllPrintersByTableId(id);

        // Get List Embroideries by table_id
        List<Embroidery> embroideryListByTableId = this.embroideryService.getAllEmbroideriesByTableId(id);

        // Get List Sewings by table_id
        List<Sewing> sewingListByTableId = this.sewingService.getAllSewingsByTableId(id);

        // Get List Material by table_id
        List<Material> materialListByTableId = this.materialServie.getAllMaterialsByTableId(id);

        if (productListByTableId.size() == 0 && printerListByTableId.size() == 0 && embroideryListByTableId.size() == 0 && sewingListByTableId.size() == 0 && materialListByTableId.size() == 0) {
            log.info("Delete an orderTable by id = " + id);
            this.orderTableService.deleteOrderTable(id);
        }

        return new ModelAndView("redirect:/tables");
    }


}
