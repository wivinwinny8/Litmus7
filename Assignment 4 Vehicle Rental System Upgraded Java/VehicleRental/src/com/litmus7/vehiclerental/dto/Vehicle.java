package com.litmus7.vehiclerental.dto;
import java.util.*;

/**
 * This class represents a vehicle It has method inputDetails() to read data of
 * the vehicle displayDetails() to display data of the vehicle
 */
public class Vehicle {
	public String brand;
	public String model;
	public double rentalPricePerDay;
	Scanner scan = new Scanner(System.in);

	/**
	 * Default constructor for Vehicle class All values are set to null since
	 * default values are not mentioned
	 */
	public Vehicle() {
		this.brand = "Null";
		this.model = "Null";
		this.rentalPricePerDay = 0.00;
	}

	/**
	 * Parameterized constructor for Vehicle class
	 * 
	 * @param brand             Brand of the vehicle
	 * @param model             Model of the vehicle
	 * @param rentalPricePerDay Rental price of the vehicle per day
	 */
	public Vehicle(String brand, String model, double rentalPricePerDay) {
		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
	}

	/**
	 * Reads the input details of the vehicle from the user
	 */
	public void inputDetails() {
		System.out.print("enter the brand name : ");
		this.brand = scan.next();
		System.out.print("enter the model name : ");
		this.model = scan.next();
		System.out.print("enter the rental price per day : ");
		this.rentalPricePerDay = scan.nextDouble();
	}

	/**
	 * Displays the details of the vehicle
	 */
	public void displayDetails() {
		System.out.printf("brand : %s\nmodel : %s\nrental price/day : %.2f\n", this.brand, this.model,
				this.rentalPricePerDay);
	}

}
