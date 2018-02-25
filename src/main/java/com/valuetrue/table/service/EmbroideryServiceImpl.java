package com.valuetrue.table.service;

import com.valuetrue.table.dao.EmbroideryDAO;
import com.valuetrue.table.model.Embroidery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;




@Service
public class EmbroideryServiceImpl implements EmbroideryService {

    private EmbroideryDAO embroideryDAO;

    @Autowired
    public void setEmbroideryDAO(EmbroideryDAO embroideryDAO) {
        this.embroideryDAO = embroideryDAO;
    }


    @Override
    public void saveEmbroidery(Embroidery embroidery) {
        this.embroideryDAO.saveEmbroidery(embroidery);
    }

    @Override
    public void updateEmbroidery(Embroidery embroidery) {
        this.embroideryDAO.updateEmbroidery(embroidery);
    }

    @Override
    public void deleteEmbroidery(int id) {
        this.embroideryDAO.deleteEmbroidery(id);
    }

    @Override
    public Embroidery getEmbroideryById(int id) {
        if(id != 0)
            return this.embroideryDAO.getEmbroideryById(id);
        else
            return this.embroideryDAO.getEmbroideryById(0);
    }

    @Override
    public List<Embroidery> getAllEmbroideries() {

        return this.embroideryDAO.getAllEmbroideries();
    }

    @Override
    public List<Embroidery> getAllEmbroideriesByTableId(int table_id) {

        return this.embroideryDAO.getAllEmbroideriesByTableId(table_id);
    }
}
