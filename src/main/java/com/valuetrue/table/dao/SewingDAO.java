package com.valuetrue.table.dao;

import com.valuetrue.table.model.Sewing;


import java.util.List;


public interface SewingDAO {

    public void saveSewing(Sewing sewing);
    public void updateSewing(Sewing sewing);
    public void deleteSewing(int id);
    public Sewing getSewingById(int id);
    public List<Sewing> getAllSewings();
    public List<Sewing> getAllSewingsByTableId(int table_id);

}
