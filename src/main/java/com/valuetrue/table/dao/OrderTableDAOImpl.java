package com.valuetrue.table.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.valuetrue.table.model.OrderTable;



@Repository
public class OrderTableDAOImpl implements OrderTableDAO{
	
	private JdbcTemplate jdbcTemplateServlet;
	
	// JdbcTemplate setter <property name="jdbcTemplateServlet" ... />  in servlet-context.xml
	@Autowired
	public void setJdbcTemplateServlet(JdbcTemplate jdbcTemplateServlet) {
		this.jdbcTemplateServlet = jdbcTemplateServlet;
	}

	// SAVE a new orderTable 
	@Override
	public void saveOrderTable(OrderTable orderTable) {
		String sql = "insert into Ordertable(name,pre_weight,after_weight) values(?,?,?)";
		jdbcTemplateServlet.update(sql, new Object[]{ orderTable.getName(), orderTable.getPre_weight(), orderTable.getAfter_weight() });
	}

	// UPDATE a particular orderTable by Id
	@Override
	public void updateOrderTable(OrderTable orderTable) {
		String sql = "update ordertable set pre_weight =?, after_weight =?,name=? where id=?";
		jdbcTemplateServlet.update(sql, new Object[]{ orderTable.getPre_weight(), orderTable.getAfter_weight(), orderTable.getName(), orderTable.getId() });
		
	}

	// DELETE a orderTable by Id
	@Override
	public void deleteOrderTable(int id) {
		String sql = "delete from ordertable where id=?";
        jdbcTemplateServlet.update(sql, new Object[]{ id });	
	}

	// GET a orderTable by Id
	@Override
	public OrderTable getOrderTableById(int id) {
		String sql = "select * from Ordertable where id=?";
		OrderTable orderTable = (OrderTable) jdbcTemplateServlet.queryForObject(sql, new Object[] {id}, 
				new RowMapper<OrderTable>() {
					@Override
					public OrderTable mapRow(ResultSet rs, int rowNum) throws SQLException {
						OrderTable orderTab = new OrderTable();
						orderTab.setId(rs.getInt(1));
						orderTab.setName(rs.getString(2));
						orderTab.setPre_weight(rs.getInt(3));
						orderTab.setAfter_weight(rs.getInt(4));
						return orderTab;
					}
				});
		return orderTable;
	}

	
	// GET all orderTable
	@Override
	public List<OrderTable> getAllOrderTables() {
		String sql = "select * from ordertable";
        List<OrderTable> orderTableList = jdbcTemplateServlet.query(sql, new ResultSetExtractor<List<OrderTable>>(){
            @Override
            public List<OrderTable> extractData(ResultSet rs) throws SQLException, DataAccessException{
                List<OrderTable> list = new ArrayList<OrderTable>();
                while (rs.next()){
                	OrderTable orderTab = new OrderTable();          
                	orderTab.setId(rs.getInt(1));
                	orderTab.setName(rs.getString(2));
                	orderTab.setPre_weight(rs.getInt(3));      
                	orderTab.setAfter_weight(rs.getInt(4));
                    list.add(orderTab);
                }
                return list;
            }
        });        
        return orderTableList;
	}

}
