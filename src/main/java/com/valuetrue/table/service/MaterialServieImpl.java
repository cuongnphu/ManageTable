package com.valuetrue.table.service;

import com.valuetrue.table.dao.MaterialDAO;
import com.valuetrue.table.model.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class MaterialServieImpl implements MaterialServie {

    private MaterialDAO materialDAO;

    @Autowired
    public void setMaterialDAO(MaterialDAO materialDAO) {
        this.materialDAO = materialDAO;
    }

    @Override
    public void saveMaterial(Material material) {
        if(material.getName()!="" && material.getWeight()>0 && material.getNum_class()>0 && material.getQuantity()>0){
            this.materialDAO.saveMaterial(material);
        }
    }

    @Override
    public void updateMaterial(Material material) {
        if(material.getName()!="" && material.getWeight()>0 && material.getNum_class()>0 && material.getQuantity()>0) {
            this.materialDAO.updateMaterial(material);
        }
    }

    @Override
    public void deleteMaterial(int id) {
        this.materialDAO.deleteMaterial(id);
    }

    @Override
    public Material getMaterialById(int id) {
        if(id != 0)
            return this.materialDAO.getMaterialById(id);
        else
            return this.materialDAO.getMaterialById(0);
    }

    @Override
    public List<Material> getAllMaterials() {
        return this.materialDAO.getAllMaterials();
    }

    @Override
    public List<Material> getAllMaterialsByTableId(int table_id) {
        return this.materialDAO.getAllMaterialsByTableId(table_id);
    }
}
