package com.valuetrue.table.service;

import com.valuetrue.table.dao.SewingDAO;
import com.valuetrue.table.model.Sewing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SewingServiceImpl implements SewingService {

    private SewingDAO sewingDAO;

    @Autowired
    public void setSewingDAO(SewingDAO sewingDAO) {
        this.sewingDAO = sewingDAO;
    }

    @Override
    public void saveSewing(Sewing sewing) {
        if (sewing.getName() != "" && sewing.getPrice() > 0 && sewing.getQuantity() > 0) {
            // Caculate total = price * quantity
            Integer total = sewing.getPrice() * sewing.getQuantity();
            sewing.setTotal(total);
            this.sewingDAO.saveSewing(sewing);
        }

    }

    @Override
    public void updateSewing(Sewing sewing) {
        if (sewing.getName() != "" && sewing.getPrice() > 0 && sewing.getQuantity() > 0) {
            // Caculate total = price * quantity
            Integer total = sewing.getPrice() * sewing.getQuantity();
            sewing.setTotal(total);
            this.sewingDAO.updateSewing(sewing);
        }
    }

    @Override
    public void deleteSewing(int id) {
        this.sewingDAO.deleteSewing(id);
    }

    @Override
    public Sewing getSewingById(int id) {
        if (id != 0)
            return this.sewingDAO.getSewingById(id);
        else
            return this.sewingDAO.getSewingById(0);
    }

    @Override
    public List<Sewing> getAllSewings() {
        return this.sewingDAO.getAllSewings();
    }

    @Override
    public List<Sewing> getAllSewingsByTableId(int table_id) {
        return this.sewingDAO.getAllSewingsByTableId(table_id);
    }
}
