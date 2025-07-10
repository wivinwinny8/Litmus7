package com.litmus7.retailproductcatalog.dao;

import java.sql.SQLException;

import com.litmus7.retailproductcatalog.dto.Product;
import com.litmus7.retailproductcatalog.exceptions.NegativePriceOrStockException;
import com.litmus7.retailproductcatalog.exceptions.NoProductFoundException;

public class ProductDAO {
	public void addProduct(Product product) throws NegativePriceOrStockException, SQLException {
		String name, category;
		int productId, stockQuantity;
		double price;
		name = product.getName();
		category = product.getCategory();
		productId = product.getProductId();
		stockQuantity = product.getStockQuantity();
		price = product.getPrice();
		if (price < 0) {
			throw new NegativePriceOrStockException("Price is negative");
		} else if (stockQuantity < 0) {
			throw new NegativePriceOrStockException("Stock quantity is negative");
		}
		ProductDAOImpl productDaoImpl = new ProductDAOImpl();
		productDaoImpl.addProduct(product);
	}

	public Product getProductById(int productId) throws SQLException, NoProductFoundException {
		Product product;
		ProductDAOImpl productDaoImpl = new ProductDAOImpl();
		product = productDaoImpl.getProductById(productId);
		return product;

	}

	public void updateProduct(int productId) throws SQLException, NoProductFoundException {
		ProductDAOImpl productDaoImpl = new ProductDAOImpl();
		productDaoImpl.updateProduct(productId);
	}

	public void deleteProduct(int productId) throws SQLException, NoProductFoundException {
		ProductDAOImpl productDaoImpl = new ProductDAOImpl();
		productDaoImpl.deleteProduct(productId);
	}
}
