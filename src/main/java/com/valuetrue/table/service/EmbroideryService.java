package com.valuetrue.table.service;

import com.valuetrue.table.model.Embroidery;

import java.util.List;



public interface EmbroideryService {

    public void saveEmbroidery(Embroidery embroidery);
    public void updateEmbroidery(Embroidery embroidery);
    public void deleteEmbroidery(int id);
    public Embroidery getEmbroideryById(int id);
    public List<Embroidery> getAllEmbroideries();
    public List<Embroidery> getAllEmbroideriesByTableId(int table_id);
    public List<Embroidery> getAllEmbroideriesByName(String name);

}
