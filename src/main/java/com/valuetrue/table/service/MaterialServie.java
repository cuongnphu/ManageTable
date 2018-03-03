package com.valuetrue.table.service;


import com.valuetrue.table.model.Material;

import java.util.List;



public interface MaterialServie {

    public void saveMaterial(Material material);
    public void updateMaterial(Material material);
    public void deleteMaterial(int id);
    public Material getMaterialById(int id);
    public List<Material> getAllMaterials();
    public List<Material> getAllMaterialsByTableId(int table_id);
}
