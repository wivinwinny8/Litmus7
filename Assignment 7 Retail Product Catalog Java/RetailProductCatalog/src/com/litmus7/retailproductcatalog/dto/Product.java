package com.litmus7.retailproductcatalog.dto;

public class Product {
	private int productId;
	private String name;
	private String category;
	private double price;
	private int stockQuantity;

	public Product(int productId, String name, String category, double price, int stockQuantity) {
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	public Product() {
		this.productId = (int) (Math.random() * 1000) + 1;
		this.name = "None";
		this.category = "Uncategorised";
		this.price = 0;
		this.stockQuantity = 0;
	}

	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}
}
