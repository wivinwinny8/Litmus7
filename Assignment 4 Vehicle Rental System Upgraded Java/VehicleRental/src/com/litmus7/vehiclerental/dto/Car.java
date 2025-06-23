package com.litmus7.vehiclerental.dto;
import java.util.*;

/**
 * This class represents a car which is a subclass of vehicle class
 */
public class Car extends Vehicle {
	public int numberOfDoors;
	public boolean isAutomatic;
	Scanner scan = new Scanner(System.in);

	/**
	 * Default constructor for Car class
	 */
	public Car() {
		super("Honda", "Civic", 1400.0);
		this.numberOfDoors = 4;
		this.isAutomatic = false;
	}

	/**
	 * Parameterized constructor for Car class
	 * 
	 * @param brand             Brand of the car
	 * @param model             Model of the car
	 * @param rentalPricePerDay Rental price per day for the car
	 * @param numberOfDoors     Number of doors in the car
	 * @param isAutomatic       Is the car automatic or not
	 */
	public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
		super(brand, model, rentalPricePerDay);
		this.numberOfDoors = numberOfDoors;
		this.isAutomatic = isAutomatic;
	}

	/**
	 * Reads input details of the car, calls superclass method inputDetails() for
	 * reading common features
	 */
	public void inputDetails() {
		System.out.println("---Enter Car Details---");
		super.inputDetails();
		System.out.print("enter number of doors : ");
		numberOfDoors = scan.nextInt();
		System.out.print("is it automatic(true/false)? : ");
		isAutomatic = scan.nextBoolean();
	}

	/**
	 * Displays the details of the car, calls superclass method displayDetails() for
	 * displaying common features
	 */
	public void displayDetails() {
		System.out.println("---Displaying Car Details---");
		super.displayDetails();
		System.out.printf("number of doors : %d\nis automatic : %b\n", numberOfDoors, isAutomatic);
	}
}