package com.litmus7.vehiclerental.dto;

import java.util.*;

/**
 * This class represents a bike which is a subclass of vehicle class
 */

public class Bike extends Vehicle {
	public boolean hasGear;
	public int engineCapacity;
	Scanner scan = new Scanner(System.in);

	/**
	 * Default constructor for Bike class
	 */
	public Bike() {
		super("Suzuki", "Gixxer", 600.0);
		this.hasGear = false;
		this.engineCapacity = 125;
	}

	/**
	 * Parameterized constructor for Bike class
	 * 
	 * @param brand             Brand of the bike
	 * @param model             Model of the bike
	 * @param rentalPricePerDay Rental price per day for the bike
	 * @param hasGear           Does the bike have gear or not
	 * @param engineCapacity    Engine capacity of the bike
	 */
	public Bike(String brand, String model, double rentalPricePerDay, boolean hasGear, int engineCapacity) {
		super(brand, model, rentalPricePerDay);
		this.hasGear = hasGear;
		this.engineCapacity = engineCapacity;
	}

	/**
	 * Reads input details of the bike, calls superclass method inputDetails() for
	 * reading common features
	 */
	public void inputDetails() {
		System.out.println("---Enter Bike Details---");
		super.inputDetails();
		System.out.print("enter the engine capacity : ");
		engineCapacity = scan.nextInt();
		System.out.print("does it have gears(true/false)? : ");
		hasGear = scan.nextBoolean();
	}

	/**
	 * Displays the details of the bike, calls superclass method displayDetails()
	 * for displaying common features
	 */
	public void displayDetails() {
		System.out.println("---Displaying Bike Details---");
		super.displayDetails();
		System.out.printf("has gear : %b\nengine capacity : %dcc\n", hasGear, engineCapacity);
	}
}
