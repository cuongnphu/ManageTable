package com.valuetrue.table.dao;

import com.valuetrue.table.model.Sewing;
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
public class SewingDAOImpl implements SewingDAO {

    private JdbcTemplate jdbcTemplateServlet;

    // JdbcTemplate setter <property name="jdbcTemplateServlet" ... /> in servlet-context.xml
    @Autowired
    public void setJdbcTemplateServlet(JdbcTemplate jdbcTemplateServlet) {
        this.jdbcTemplateServlet = jdbcTemplateServlet;
    }

    // SAVE a new Sewing
    @Override
    public void saveSewing(Sewing sewing) {
        String sql = "insert into Sewing(name,table_id,price,quantity,total) value(?,?,?,?,?)";
        jdbcTemplateServlet.update(sql, new Object[]{sewing.getName(), sewing.getTable_id(), sewing.getPrice(), sewing.getQuantity(), sewing.getTotal()});
    }

    // UPDATE a particular Sewing
    @Override
    public void updateSewing(Sewing sewing) {
        String sql = "update Sewing set name =?, table_id =?, price =?, quantity =?, total =? where id=?";
        jdbcTemplateServlet.update(sql, new Object[]{sewing.getName(), sewing.getTable_id(), sewing.getPrice(), sewing.getQuantity(), sewing.getTotal(), sewing.getId()});
    }

    // DELETE a particular Sewing
    @Override
    public void deleteSewing(int id) {
        String sql = "delete from Sewing where id=?";
        jdbcTemplateServlet.update(sql, new Object[]{id});
    }

    // GET a particular Sewing by Id
    @Override
    public Sewing getSewingById(int id) {
        String sql = "select * from Sewing where id=?";
        Sewing sew = (Sewing) jdbcTemplateServlet.queryForObject(sql, new Object[]{id}, new RowMapper<Sewing>() {
            @Override
            public Sewing mapRow(ResultSet rs, int rowNum) throws SQLException {
                Sewing sew = new Sewing();
                sew.setId(rs.getInt(1));
                sew.setName(rs.getString(2));
                sew.setTable_id(rs.getInt(3));
                sew.setPrice(rs.getInt(4));
                sew.setQuantity(rs.getInt(5));
                sew.setTotal(rs.getInt(6));
                return sew;
            }
        });

        return sew;
    }


    // GET all Sewings
    @Override
    public List<Sewing> getAllSewings() {
        String sql = "select * from Sewing";
        List<Sewing> sewingList = jdbcTemplateServlet.query(sql, new ResultSetExtractor<List<Sewing>>() {
            @Override
            public List<Sewing> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Sewing> list = new ArrayList<Sewing>();
                while (rs.next()) {
                    Sewing sew = new Sewing();
                    sew.setId(rs.getInt(1));
                    sew.setName(rs.getString(2));
                    sew.setTable_id(rs.getInt(3));
                    sew.setPrice(rs.getInt(4));
                    sew.setQuantity(rs.getInt(5));
                    sew.setTotal(rs.getInt(6));
                    list.add(sew);
                }
                return list;
            }
        });

        return sewingList;
    }

    // GET all Sewings by table_id
    @Override
    public List<Sewing> getAllSewingsByTableId(int table_id) {
        String sql = "select * from Sewing where table_id=?";
        List<Sewing> sewingList = jdbcTemplateServlet.query(sql, new Object[]{table_id} ,new ResultSetExtractor<List<Sewing>>() {
            @Override
            public List<Sewing> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Sewing> list = new ArrayList<Sewing>();
                while (rs.next()) {
                    Sewing sew = new Sewing();
                    sew.setId(rs.getInt(1));
                    sew.setName(rs.getString(2));
                    sew.setTable_id(rs.getInt(3));
                    sew.setPrice(rs.getInt(4));
                    sew.setQuantity(rs.getInt(5));
                    sew.setTotal(rs.getInt(6));
                    list.add(sew);
                }
                return list;
            }
        });

        return sewingList;
    }
}
