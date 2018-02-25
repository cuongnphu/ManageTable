package com.valuetrue.table.service;

import com.valuetrue.table.dao.OrderTableDAO;
import com.valuetrue.table.dao.ProductDAO;
import com.valuetrue.table.model.OrderTable;
import com.valuetrue.table.model.Product;
import com.valuetrue.table.model.TableForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetailTableServiceImpl implements DetailTableService {

    private OrderTableDAO orderTableDAO;
    private ProductDAO productDAO;

    @Autowired
    public void setOrderTableDAO(OrderTableDAO orderTableDAO) {
        this.orderTableDAO = orderTableDAO;
    }

    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<TableForm> getAllTableForm() {

        List<TableForm> listTableForm = new ArrayList<TableForm>();

        List<OrderTable> listOrderTable = this.orderTableDAO.getAllOrderTables();

        for (OrderTable orderTab: listOrderTable ) {
            TableForm tabForm = new TableForm();
            List<Product> listProds = this.productDAO.getAllProductsByTableId(orderTab.getId());
            tabForm.setOrderTable(orderTab);
            tabForm.setProds(listProds);
            listTableForm.add(tabForm);
        }

        return listTableForm;
    }
}
