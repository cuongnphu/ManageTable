package com.valuetrue.table.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.valuetrue.table.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	private JdbcTemplate jdbcTemplateServlet;

	// JdbcTemplate setter <property name="jdbcTemplateServlet" ... /> in
	// servlet-context.xml
	@Autowired
	public void setJdbcTemplateServlet(JdbcTemplate jdbcTemplateServlet) {
		this.jdbcTemplateServlet = jdbcTemplateServlet;
	}

	// SAVE a new Product
	@Override
	public void saveProduct(Product product) {
		String sql = "insert into Product(table_id,name,quantity) values(?,?,?)";
		jdbcTemplateServlet.update(sql,
				new Object[] { product.getTable_id(), product.getName(), product.getQuantity() });

	}

	// UPDATE a particular product
	@Override
	public void updateProduct(Product product) {
		String sql = "update Product set table_id =?, name =?, quantity =? where id=?";
		jdbcTemplateServlet.update(sql,
				new Object[] { product.getTable_id(), product.getName(), product.getQuantity(), product.getId() });

	}

	// DELETE a product
	@Override
	public void deleteProduct(int id) {
		String sql = "delete from Product where id=?";
		jdbcTemplateServlet.update(sql, new Object[] { id });
	}

	// GET a product by Id
	@Override
	public Product getProductById(int id) {
		String sql = "select * from Product where id=?";
		Product product = (Product) jdbcTemplateServlet.queryForObject(sql, new Object[] { id },
				new RowMapper<Product>() {
					@Override
					public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
						Product prod = new Product();
						prod.setId(rs.getInt(1));
						prod.setTable_id(rs.getInt(2));
						prod.setName(rs.getString(3));
						prod.setQuantity(rs.getInt(4));
						return prod;
					}
				});
		return product;

	}

	// GET all products
	@Override
	public List<Product> getAllProducts() {
		String sql = "select * from Product";
		List<Product> productList = jdbcTemplateServlet.query(sql, new ResultSetExtractor<List<Product>>() {
			@Override
			public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Product> list = new ArrayList<Product>();
				while (rs.next()) {
					Product prod = new Product();
					prod.setId(rs.getInt(1));
					prod.setTable_id(rs.getInt(2));
					prod.setName(rs.getString(3));
					prod.setQuantity(rs.getInt(4));
					list.add(prod);
				}
				return list;
			}
		});
		return productList;
	}

	
	// GET all products by table_id
	@Override
	public List<Product> getAllProductsByTableId(int table_id) {
		String sql = "select * from Product where table_id=?";
		List<Product> productList = jdbcTemplateServlet.query(sql, new Object[] {table_id}, new ResultSetExtractor<List<Product>>() {
			@Override
			public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Product> list = new ArrayList<Product>();
				while (rs.next()) {
					Product prod = new Product();
					prod.setId(rs.getInt(1));
					prod.setTable_id(rs.getInt(2));
					prod.setName(rs.getString(3));
					prod.setQuantity(rs.getInt(4));
					list.add(prod);
				}
				return list;
			}
		});
			
		return productList;
	}

}
