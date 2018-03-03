package com.valuetrue.table.service;

import com.valuetrue.table.dao.*;
import com.valuetrue.table.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetailTableServiceImpl implements DetailTableService {

    private OrderTableDAO orderTableDAO;
    private ProductDAO productDAO;
    private PrinterDAO printerDAO;
    private EmbroideryDAO embroideryDAO;
    private SewingDAO sewingDAO;
    private MaterialDAO materialDAO;

    @Autowired
    public void setOrderTableDAO(OrderTableDAO orderTableDAO) {
        this.orderTableDAO = orderTableDAO;
    }

    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Autowired
    public void setPrinterDAO(PrinterDAO printerDAO) {
        this.printerDAO = printerDAO;
    }

    @Autowired
    public void setEmbroideryDAO(EmbroideryDAO embroideryDAO) {
        this.embroideryDAO = embroideryDAO;
    }

    @Autowired
    public void setSewingDAO(SewingDAO sewingDAO) {
        this.sewingDAO = sewingDAO;
    }

    @Autowired
    public void setMaterialDAO(MaterialDAO materialDAO) {
        this.materialDAO = materialDAO;
    }


    @Override
    public List<TableForm> getAllTableForm() {

        List<TableForm> listTableForm = new ArrayList<TableForm>();

        List<OrderTable> listOrderTable = this.orderTableDAO.getAllOrderTables();

        for (OrderTable orderTab: listOrderTable ) {
            TableForm tabForm = new TableForm();
            List<Product> listProds = this.productDAO.getAllProductsByTableId(orderTab.getId());
            List<Printer> printerList = this.printerDAO.getAllPrintersByTableId(orderTab.getId());
            List<Embroidery> embroideryList = this.embroideryDAO.getAllEmbroideriesByTableId(orderTab.getId());
            List<Sewing> sewingList = this.sewingDAO.getAllSewingsByTableId(orderTab.getId());
            List<Material> materialList = this.materialDAO.getAllMaterialsByTableId(orderTab.getId());
            tabForm.setOrderTable(orderTab);
            tabForm.setProductList(listProds);
            tabForm.setPrinterList(printerList);
            tabForm.setEmbroideryList(embroideryList);
            tabForm.setSewingList(sewingList);
            tabForm.setMaterialList(materialList);
            listTableForm.add(tabForm);
        }

        return listTableForm;
    }
}
