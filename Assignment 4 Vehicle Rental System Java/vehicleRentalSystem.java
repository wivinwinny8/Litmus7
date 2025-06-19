package com.litmus7.vehiclerentalsystem.dto;

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

/**
 * This class represents a car which is a subclass of vehicle class
 */
class Car extends Vehicle {
	public int numberOfDoors;
	public boolean isAutomatic;
	Scanner scan = new Scanner(System.in);

	/**
	 * Default constructor for Car class
	 */
	Car() {
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
	Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
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

/**
 * This class represents a bike which is a subclass of vehicle class
 */

class Bike extends Vehicle {
	public boolean hasGear;
	public int engineCapacity;

	/**
	 * Default constructor for Bike class
	 */
	Bike() {
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
	Bike(String brand, String model, double rentalPricePerDay, boolean hasGear, int engineCapacity) {
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

/**
 * VehicleApp class which contains the main method objects of class Car and Bike
 * is created
 */
class VehicleApp {
	public static void main(String[] args) {
		Car car1 = new Car();
		car1.inputDetails();
		car1.displayDetails();
		Car car2 = new Car();
		car2.displayDetails();
		Bike bike1 = new Bike();
		bike1.inputDetails();
		bike1.displayDetails();
		Bike bike2 = new Bike();
		bike2.displayDetails();
	}
}
