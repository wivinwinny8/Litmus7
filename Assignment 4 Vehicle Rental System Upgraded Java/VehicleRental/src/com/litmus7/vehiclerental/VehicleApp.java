package com.litmus7.vehiclerental;

import com.litmus7.vehiclerental.dto.*;

/**
 * VehicleApp class which contains the main method objects of class Car and Bike
 * is created
 */
class VehicleApp {
	public static void main(String[] args) {
		VehicleService service = new VehicleService();
		// loads vehicle data from vehicles.txt
		service.loadVehicleData("src/resources/vehicles.txt");

		// creates a new car
		Car newCar = new Car("Hyundai", "i10 Grand", 40.0, 4, false);

		// adding the new car
		service.addVehicle(newCar);

		// creating a new bike
		Bike newBike = new Bike("Yamaha", "MT15", 25.0, true, 150);

		// adding the new bike
		service.addVehicle(newBike);

		// displaying the data
		service.displayVehicle();

		//using default constructors
		Car newCar2=new Car();
		Bike newBike2=new Bike();
		
		//adding the vehicles 
		service.addVehicle(newCar2);
		service.addVehicle(newBike2);
		
		// displaying the updated data
		service.displayVehicle();
		
		//displaying total rental price of all vehicles
		service.totalRentalPrice();
	}
}