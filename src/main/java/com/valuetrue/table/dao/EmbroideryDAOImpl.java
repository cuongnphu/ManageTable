package com.valuetrue.table.dao;

import com.valuetrue.table.model.Embroidery;

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
public class EmbroideryDAOImpl implements EmbroideryDAO {

    private JdbcTemplate jdbcTemplateServlet;

    // JdbcTemplate setter <property name="jdbcTemplateServlet" ... /> in servlet-context.xml
    @Autowired
    public void setJdbcTemplateServlet(JdbcTemplate jdbcTemplateServlet) {
        this.jdbcTemplateServlet = jdbcTemplateServlet;
    }

    // SAVE a new Embroidery
    @Override
    public void saveEmbroidery(Embroidery embroidery) {
        String sql = "insert into Embroidery(name,table_id,price,quantity,total) value(?,?,?,?,?)";
        jdbcTemplateServlet.update(sql, new Object[]{embroidery.getName(), embroidery.getTable_id(), embroidery.getPrice(), embroidery.getQuantity(), embroidery.getTotal()});
    }

    // UPDATE a particular Embroidery
    @Override
    public void updateEmbroidery(Embroidery embroidery) {
        String sql = "update Embroidery set name =?, table_id =?, price =?, quantity =?, total =? where id=?";
        jdbcTemplateServlet.update(sql, new Object[]{embroidery.getName(), embroidery.getTable_id(), embroidery.getPrice(), embroidery.getQuantity(), embroidery.getTotal(), embroidery.getId()});
    }

    // DELETE a particular Embroidery by Id
    @Override
    public void deleteEmbroidery(int id) {
        String sql = "delete from Embroidery where id=?";
        jdbcTemplateServlet.update(sql, new Object[]{id});
    }

    // GET a particular Embroidery by Id
    @Override
    public Embroidery getEmbroideryById(int id) {
        String sql = "select * from Embroidery where id=?";
        Embroidery embroidery = (Embroidery) jdbcTemplateServlet.query(sql, new Object[]{id}, new RowMapper<Embroidery>() {
            @Override
            public Embroidery mapRow(ResultSet rs, int rowNum) throws SQLException {
                Embroidery embroid = new Embroidery();
                embroid.setId(rs.getInt(1));
                embroid.setName(rs.getString(2));
                embroid.setTable_id(rs.getInt(3));
                embroid.setPrice(rs.getInt(4));
                embroid.setQuantity(rs.getInt(5));
                embroid.setTotal(rs.getInt(6));
                return embroid;
            }

        });
        return embroidery;
    }

    // GET all Embroideries
    @Override
    public List<Embroidery> getAllEmbroideries() {
        String sql = "select * from Embroidery";
        List<Embroidery> embroideryList = jdbcTemplateServlet.query(sql, new ResultSetExtractor<List<Embroidery>>() {
            @Override
            public List<Embroidery> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Embroidery> list = new ArrayList<Embroidery>();
                while (rs.next()) {
                    Embroidery embroid = new Embroidery();
                    embroid.setId(rs.getInt(1));
                    embroid.setName(rs.getString(2));
                    embroid.setTable_id(rs.getInt(3));
                    embroid.setPrice(rs.getInt(4));
                    embroid.setQuantity(rs.getInt(5));
                    embroid.setTotal(rs.getInt(6));
                    list.add(embroid);
                }
                return list;
            }
        });
        return embroideryList;
    }

    // GET a particular Embroidery by table_id
    @Override
    public List<Embroidery> getAllEmbroideriesByTableId(int table_id) {
        String sql = "select * from Embroidery where table_id=?";
        List<Embroidery> embroideryList = jdbcTemplateServlet.query(sql, new Object[]{table_id} ,new ResultSetExtractor<List<Embroidery>>() {
            @Override
            public List<Embroidery> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Embroidery> list = new ArrayList<Embroidery>();
                while (rs.next()) {
                    Embroidery embroid = new Embroidery();
                    embroid.setId(rs.getInt(1));
                    embroid.setName(rs.getString(2));
                    embroid.setTable_id(rs.getInt(3));
                    embroid.setPrice(rs.getInt(4));
                    embroid.setQuantity(rs.getInt(5));
                    embroid.setTotal(rs.getInt(6));
                    list.add(embroid);
                }
                return list;
            }
        });
        return embroideryList;
    }
}
