package com.valuetrue.table.dao;

import com.valuetrue.table.model.Printer;
import com.valuetrue.table.model.Product;
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
public class PrinterDAOImpl implements PrinterDAO {

    private JdbcTemplate jdbcTemplateServlet;

    // JdbcTemplate setter <property name="jdbcTemplateServlet" ... /> in servlet-context.xml
    @Autowired
    public void setJdbcTemplateServlet(JdbcTemplate jdbcTemplateServlet) {
        this.jdbcTemplateServlet = jdbcTemplateServlet;
    }

    // SAVE a new Printer
    @Override
    public void savePrinter(Printer printer) {
        String sql = "insert into Printer(name,table_id,price,quantity,total) value(?,?,?,?,?)";
        jdbcTemplateServlet.update(sql, new Object[]{printer.getName(), printer.getTable_id(), printer.getPrice(), printer.getQuantity(), printer.getTotal()});
    }

    // UPDATE a particular Printer
    @Override
    public void updatePrinter(Printer printer) {
        String sql = "update Printer set name =?, table_id =?, price =?, quantity =?, total =? where id=?";
        jdbcTemplateServlet.update(sql, new Object[]{printer.getName(), printer.getTable_id(), printer.getPrice(), printer.getQuantity(), printer.getTotal(), printer.getId()});
    }

    // DELETE a particular Printer by Id
    @Override
    public void deletePrinter(int id) {
        String sql = "delete from Printer where id=?";
        jdbcTemplateServlet.update(sql, new Object[]{id});
    }


    // GET a particular Printer by Id
    @Override
    public Printer getPrinterById(int id) {
        String sql = "select * from Printer where id=?";
        Printer printer = (Printer) jdbcTemplateServlet.queryForObject(sql, new Object[]{id}, new RowMapper<Printer>() {
            @Override
            public Printer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Printer print = new Printer();
                print.setId(rs.getInt(1));
                print.setName(rs.getString(2));
                print.setTable_id(rs.getInt(3));
                print.setPrice(rs.getInt(4));
                print.setQuantity(rs.getInt(5));
                print.setTotal(rs.getInt(6));
                return print;
            }

        });
        return printer;
    }

    // GET all Printers
    @Override
    public List<Printer> getAllPrinters() {
        String sql = "select * from Printer";
        List<Printer> printerList = jdbcTemplateServlet.query(sql, new ResultSetExtractor<List<Printer>>() {
            @Override
            public List<Printer> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Printer> list = new ArrayList<Printer>();
                while (rs.next()) {
                    Printer print = new Printer();
                    print.setId(rs.getInt(1));
                    print.setName(rs.getString(2));
                    print.setTable_id(rs.getInt(3));
                    print.setPrice(rs.getInt(4));
                    print.setQuantity(rs.getInt(5));
                    print.setTotal(rs.getInt(6));
                    list.add(print);
                }
                return list;
            }
        });
        return printerList;
    }

    // GET all Printers by table_id
    @Override
    public List<Printer> getAllPrintersByTableId(int table_id) {
        String sql = "select * from Printer where table_id=?";
        List<Printer> printerList = jdbcTemplateServlet.query(sql, new Object[]{table_id} ,new ResultSetExtractor<List<Printer>>() {
            @Override
            public List<Printer> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Printer> list = new ArrayList<Printer>();
                while (rs.next()) {
                    Printer print = new Printer();
                    print.setId(rs.getInt(1));
                    print.setName(rs.getString(2));
                    print.setTable_id(rs.getInt(3));
                    print.setPrice(rs.getInt(4));
                    print.setQuantity(rs.getInt(5));
                    print.setTotal(rs.getInt(6));
                    list.add(print);
                }
                return list;
            }
        });
        return printerList;
    }

    @Override
    public List<Printer> getAllPrinterByName(String name) {
        String sql = "select * from Printer where name=?";
        List<Printer> printerList = jdbcTemplateServlet.query(sql, new Object[]{name} ,new ResultSetExtractor<List<Printer>>() {
            @Override
            public List<Printer> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Printer> list = new ArrayList<Printer>();
                while (rs.next()) {
                    Printer print = new Printer();
                    print.setId(rs.getInt(1));
                    print.setName(rs.getString(2));
                    print.setTable_id(rs.getInt(3));
                    print.setPrice(rs.getInt(4));
                    print.setQuantity(rs.getInt(5));
                    print.setTotal(rs.getInt(6));
                    list.add(print);
                }
                return list;
            }
        });
        return printerList;
    }
}
