package com.litmus7.retaildiscountsystem;

import com.litmus7.retaildiscountsystem.dto.*;
import java.util.*;

public class RetailStoreApp {
	public static void main(String args[]) {
		int customerType;
		double purchaseAmount;
		double finalAmount;
		Scanner scan = new Scanner(System.in);
		System.out.println("enter customer type (1- regular, 2- premium, 3- wholesale) : ");
		customerType=scan.nextInt();
		System.out.println("enter total purchase amount : ");
		purchaseAmount=scan.nextDouble();
		if(customerType==1) {
			RegularCustomer customer = new RegularCustomer();
			finalAmount=customer.applyDiscount(purchaseAmount);
			System.out.println("Final Payable Amount : " + finalAmount);
		}
		else if(customerType==2) {
			PremiumCustomer customer = new PremiumCustomer();
			finalAmount=customer.applyDiscount(purchaseAmount);
			System.out.println("Final Payable Amount : " + finalAmount);
		}
		else if(customerType==3) {
			WholesaleCustomer customer = new WholesaleCustomer();
			finalAmount=customer.applyDiscount(purchaseAmount);
			System.out.println("Final Payable Amount : " + finalAmount);
		}
		else {
			System.out.println("invalid customer type!!!");
		}
	}
}
