package com.valuetrue.table.service;


import com.valuetrue.table.model.Sewing;

import java.util.List;



public interface SewingService {

    public void saveSewing(Sewing sewing);
    public void updateSewing(Sewing sewing);
    public void deleteSewing(int id);
    public Sewing getSewingById(int id);
    public List<Sewing> getAllSewings();
    public List<Sewing> getAllSewingsByTableId(int table_id);
    public List<Sewing> getAllSewingByName(String name);
}
