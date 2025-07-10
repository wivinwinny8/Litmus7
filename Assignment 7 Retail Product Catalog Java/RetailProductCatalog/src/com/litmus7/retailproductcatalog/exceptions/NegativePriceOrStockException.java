package com.litmus7.retailproductcatalog.exceptions;

public class NegativePriceOrStockException extends Exception {
	public NegativePriceOrStockException(String message) {
		super(message);
	}
}
