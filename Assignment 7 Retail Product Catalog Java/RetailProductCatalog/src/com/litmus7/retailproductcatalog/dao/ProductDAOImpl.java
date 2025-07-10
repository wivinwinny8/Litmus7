package com.litmus7.retailproductcatalog.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.litmus7.retailproductcatalog.dto.Product;
import com.litmus7.retailproductcatalog.exceptions.EmptyListException;
import com.litmus7.retailproductcatalog.exceptions.NoProductFoundException;
import com.litmus7.retailproductcatalog.util.DatabaseConnection;

public class ProductDAOImpl {
	public void addProduct(Product product) throws SQLException {
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStm = con.prepareStatement(
				"insert into products(productId,name,category,price,stockQuantity) values (?,?,?,?,?)");
		preparedStm.setInt(1, product.getProductId());
		preparedStm.setString(2, product.getName());
		preparedStm.setString(3, product.getCategory());
		preparedStm.setDouble(4, product.getPrice());
		preparedStm.setInt(5, product.getStockQuantity());
		int status = preparedStm.executeUpdate();
		if (status > 0) {
			System.out.println("Product successfully added");
		}
	}

	public Product getProductById(int productId) throws SQLException, NoProductFoundException {
		Product product;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStm = con.prepareStatement("select * from products where productId=?");
		preparedStm.setInt(1, productId);
		ResultSet rs = preparedStm.executeQuery();
		boolean isEmpty = !(rs.next());
		if (isEmpty) {
			throw new NoProductFoundException("No product found with given id");
		} else {
			int product_Id = rs.getInt(1);
			String name = rs.getString(2);
			String category = rs.getString(3);
			double price = rs.getDouble(4);
			int stockQuantity = rs.getInt(5);
			product = new Product(product_Id, name, category, price, stockQuantity);
		}
		return product;
	}

	public List<Product> getAllProduct() throws SQLException, EmptyListException {
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStm = con.prepareStatement("select * from products");
		ResultSet rs = preparedStm.executeQuery();
		boolean isEmpty = !(rs.next());
		if (isEmpty) {
			throw new EmptyListException("No products to show, list is empty");
		}
		String name, category;
		double price;
		int productId, stockQuantity;
		List<Product> productsList = new ArrayList<Product>();
		do {
			productId = rs.getInt(1);
			name = rs.getString(2);
			category = rs.getString(3);
			price = rs.getDouble(4);
			stockQuantity = rs.getInt(5);
			Product product = new Product(productId, name, category, price, stockQuantity);
			productsList.add(product);
		} while (rs.next());
		return productsList;
	}

	public void updateProduct(int productId) throws SQLException, NoProductFoundException {
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStm = con.prepareStatement("select * from products where productId=?");
		preparedStm.setInt(1, productId);
		ResultSet rs = preparedStm.executeQuery();
		boolean isEmpty = !(rs.next());
		if (isEmpty) {
			throw new NoProductFoundException("No product with the given ID");
		}
		preparedStm = con
				.prepareStatement("update products set name=?,category=?,price=?,stockQuantity=? where productId=?");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter new product name : ");
		String name = scan.next();
		preparedStm.setString(1, name);

		System.out.println("Enter new product category : ");
		String category = scan.next();
		preparedStm.setString(2, category);

		System.out.println("Enter new product price : ");
		double price = scan.nextDouble();
		preparedStm.setDouble(3, price);

		System.out.println("Enter updated product stock quantity : ");
		int stockQuantity = scan.nextInt();
		preparedStm.setInt(4, stockQuantity);

		preparedStm.setInt(5, productId);

		int status = preparedStm.executeUpdate();
		if (status > 0) {
			System.out.println("Successfully updated product");
		} else {
			System.out.println("Unable to update product");
		}

	}

	public void deleteProduct(int productId) throws SQLException, NoProductFoundException {
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStm = con.prepareStatement("select * from products where productId=?");
		preparedStm.setInt(1, productId);
		ResultSet rs = preparedStm.executeQuery();
		boolean isEmpty = !(rs.next());
		if (isEmpty) {
			throw new NoProductFoundException("No product with the given ID");
		}
		preparedStm = con.prepareStatement("delete from products where productId=?");
		preparedStm.setInt(1, productId);
		int status = preparedStm.executeUpdate();
		if (status > 0) {
			System.out.println("Successfully updated product");
		} else {
			System.out.println("Unable to update product");
		}
	}
}
