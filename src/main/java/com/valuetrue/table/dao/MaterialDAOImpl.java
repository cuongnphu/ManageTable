package com.valuetrue.table.dao;

import com.valuetrue.table.model.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class MaterialDAOImpl implements MaterialDAO {

    private JdbcTemplate jdbcTemplateServlet;

    // JdbcTemplate setter <property name="jdbcTemplateServlet" ... /> in servlet-context.xml
    @Autowired
    public void setJdbcTemplateServlet(JdbcTemplate jdbcTemplateServlet) {
        this.jdbcTemplateServlet = jdbcTemplateServlet;
    }

    // SAVE a new material
    @Override
    public void saveMaterial(Material material) {
        String sql = "insert into Material(name,table_id,weight,num_class,quantity) value(?,?,?,?,?)";
        jdbcTemplateServlet.update(sql, new Object[]{material.getName(), material.getTable_id(), material.getWeight(), material.getNum_class(), material.getQuantity()});
    }

    // UPDATE a particular material
    @Override
    public void updateMaterial(Material material) {
        String sql = "update Material set name =?, table_id =?, weight =?, num_class =?, quantity =? where id=?";
        jdbcTemplateServlet.update(sql, new Object[]{material.getName(), material.getTable_id(), material.getWeight(), material.getNum_class(), material.getQuantity(), material.getId()});
    }

    // DELETE a particular material
    @Override
    public void deleteMaterial(int id) {
        String sql = "delete from Material where id=?";
        jdbcTemplateServlet.update(sql, new Object[]{id});
    }

    // GET a particular material by Id
    @Override
    public Material getMaterialById(int id) {
        String sql = "select * from Material where id=?";
        Material material = (Material) jdbcTemplateServlet.queryForObject(sql, new Object[]{id}, new RowMapper<Material>() {
            @Override
            public Material mapRow(ResultSet rs, int rowNum) throws SQLException {
                Material mate = new Material();
                mate.setId(rs.getInt(1));
                mate.setName(rs.getString(2));
                mate.setTable_id(rs.getInt(3));
                mate.setWeight(rs.getFloat(4));
                mate.setNum_class(rs.getInt(5));
                mate.setQuantity(rs.getInt(6));
                return mate;
            }
        });

        return material;
    }

    // GET all materials
    @Override
    public List<Material> getAllMaterials() {

        String sql = "select * from Material";
        List<Material> materialList = jdbcTemplateServlet.query(sql, new ResultSetExtractor<List<Material>>() {
            @Override
            public List<Material> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Material> list = new ArrayList<Material>();
                while (rs.next()) {
                    Material mate = new Material();
                    mate.setId(rs.getInt(1));
                    mate.setName(rs.getString(2));
                    mate.setTable_id(rs.getInt(3));
                    mate.setWeight(rs.getFloat(4));
                    mate.setNum_class(rs.getInt(5));
                    mate.setQuantity(rs.getInt(6));
                    list.add(mate);
                }
                return list;
            }
        });
        return materialList;
    }

    // GET all materials by table_id
    @Override
    public List<Material> getAllMaterialsByTableId(int table_id) {
        String sql = "select * from Material where table_id=?";
        List<Material> materialList = jdbcTemplateServlet.query(sql, new Object[]{table_id} ,new ResultSetExtractor<List<Material>>() {
            @Override
            public List<Material> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Material> list = new ArrayList<Material>();
                while (rs.next()) {
                    Material mate = new Material();
                    mate.setId(rs.getInt(1));
                    mate.setName(rs.getString(2));
                    mate.setTable_id(rs.getInt(3));
                    mate.setWeight(rs.getFloat(4));
                    mate.setNum_class(rs.getInt(5));
                    mate.setQuantity(rs.getInt(6));
                    list.add(mate);
                }
                return list;
            }
        });

        return materialList;
    }
}
