package com.litmus7.retailproductcatalog.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.litmus7.retailproductcatalog.dao.ProductDAO;
import com.litmus7.retailproductcatalog.dao.ProductDAOImpl;
import com.litmus7.retailproductcatalog.dto.Product;
import com.litmus7.retailproductcatalog.exceptions.EmptyListException;
import com.litmus7.retailproductcatalog.exceptions.NegativePriceOrStockException;
import com.litmus7.retailproductcatalog.exceptions.NoProductFoundException;

public class RetailProductCatalogApp {
	public static void main(String args[]) {
		int choice;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.printf(
					"1.Add Product\n2.View Product by ID\n3.View all Products\n4.Update Product\n5.Delete Product\n6.Exit\n");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				addProduct();
				break;
			case 2:
				getProductById();
				break;
			case 3:
				getAllProducts();
				break;
			case 4:
				updateProduct();
				break;
			case 5:
				deleteProduct();
				break;
			case 6:
				break;
			default:
				System.out.println("Invalid choice, try again...");
				break;
			}
		} while (choice != 6);
	}

	private static void deleteProduct() {
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Enter product id to delete : ");
			int productId = scan.nextInt();
			ProductDAO productDao = new ProductDAO();
			productDao.deleteProduct(productId);
		} catch (SQLException e) {
			System.out.println("Error : " + e);
		}

		catch (Exception e) {
			System.out.println("Error : " + e);
		}

	}

	private static void updateProduct() {
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Enter product id to update : ");
			int productId = scan.nextInt();
			ProductDAO productDao = new ProductDAO();
			productDao.updateProduct(productId);
		} catch (SQLException e) {
			System.out.println("Error : " + e);
		}

		catch (Exception e) {
			System.out.println("Error : " + e);
		}

	}

	private static void getAllProducts() {
		try {
			List<Product> productList = new ArrayList<Product>();
			ProductDAOImpl productDaoImpl = new ProductDAOImpl();
			productList = productDaoImpl.getAllProduct();
			for (Product product : productList) {
				System.out.println("ID : " + product.getProductId() + " | Name : " + product.getName()
						+ " | Category : " + product.getCategory() + " | Price : " + product.getPrice()
						+ " | Stock Quantity : " + product.getStockQuantity());
			}
		} catch (EmptyListException e) {
			System.out.println("Error : " + e);
		} catch (SQLException e) {
			System.out.println("Error : " + e);
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}

	}

	private static void getProductById() {
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Enter product id : ");
			int productId = scan.nextInt();
			ProductDAO productDao = new ProductDAO();
			Product product = productDao.getProductById(productId);
			System.out.println("ID : " + product.getProductId() + " | Name : " + product.getName() + " | Category : "
					+ product.getCategory() + " | Price : " + product.getPrice() + " | Stock Quantity : "
					+ product.getStockQuantity());
		} catch (NoProductFoundException e) {
			System.out.println("Error : " + e);
		} catch (SQLException e) {
			System.out.println("Error : " + e);
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}

	}

	private static void addProduct() {
		Scanner scan = new Scanner(System.in);
		String name, category;
		int productId, stockQuantity;
		double price;
		try {
			System.out.println("Enter product id : ");
			productId = scan.nextInt();
			System.out.println("Enter product name : ");
			name = scan.next();
			System.out.println("Enter product category : ");
			category = scan.next();
			System.out.println("Enter product price : ");
			price = scan.nextDouble();
			System.out.println("Enter product stock quantity : ");
			stockQuantity = scan.nextInt();
			Product product = new Product(productId, name, category, price, stockQuantity);
			ProductDAO productDao = new ProductDAO();
			productDao.addProduct(product);
		} catch (NegativePriceOrStockException e) {
			System.out.println("Unable to add product.");
			System.out.println("Error : " + e);
		} catch (SQLException e) {
			System.out.println("Unable to add product.");
			System.out.println("Error : " + e);
		} catch (Exception e) {
			System.out.println("Unable to add product.");
			System.out.println("Error : " + e);
		}
	}

}
