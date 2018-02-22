package com.valuetrue.table.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valuetrue.table.dao.ProductDAO;
import com.valuetrue.table.model.Product;


@Service
public class ProductServiceImpl implements ProductService{
	
	private ProductDAO prodDAO;

	@Autowired
	public void setProdDAO(ProductDAO prodDAO) {
		this.prodDAO = prodDAO;
	}

	@Override
	public void saveProduct(Product product) {
		this.prodDAO.saveProduct(product);
	}

	@Override
	public void updateProduct(Product product) {
		this.prodDAO.updateProduct(product);
		
	}

	@Override
	public void deleteProduct(int id) {
		this.prodDAO.deleteProduct(id);
		
	}

	@Override
	public Product getProductById(int id) {	
		if(id != 0)
			return this.prodDAO.getProductById(id);
		else
			return this.prodDAO.getProductById(0);
	}

	@Override
	public List<Product> getAllProducts() {
		return this.prodDAO.getAllProducts();
	}

	@Override
	public List<Product> getAllProductsByTableId(int table_id) {
		return this.prodDAO.getAllProductsByTableId(table_id);
	}

}
