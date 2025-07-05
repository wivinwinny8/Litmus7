package com.litmus7.retaildiscountsystem.dto;

public class PremiumCustomer implements Discountable {
	public double applyDiscount(double totalAmount) {
		double discountAmount = (totalAmount * 10) / 100;
		double finalAmount = totalAmount - discountAmount;
		System.out.println("Customer Type : Premium Customer");
		System.out.println("Original Amount : " + totalAmount);
		System.out.println("Discount Applied : " + discountAmount);
		return finalAmount;
	}
}
