package com.litmus7.retaildiscountsystem.dto;

public class WholesaleCustomer implements Discountable {
	public double applyDiscount(double totalAmount) {
		double discountAmount = (totalAmount * 15) / 100;
		double finalAmount = totalAmount - discountAmount;
		System.out.println("Customer Type : Wholesale Customer");
		System.out.println("Original Amount : " + totalAmount);
		System.out.println("Discount Applied : " + discountAmount);
		return finalAmount;
	}
}
