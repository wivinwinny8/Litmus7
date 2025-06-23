package com.litmus7.vehiclerental.dto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * vehicle service class which loads data from file and add to list of type
 * Vehicle, add new vehicles, display all vehicles, search vehicles by brand or
 * model,calculate total rental price for all vehicles
 */
public class VehicleService {
	List<Vehicle> vehicles = new ArrayList<Vehicle>();

	/**
	 * reads the data from vehicles.txt using BufferedReader creates object
	 * depending on vehicle type and add to vehicles list
	 */
	public void loadVehicleData(String filePath) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts[0].equals("Car") || parts[0].equals("car")) {
					Car car = new Car(parts[1], parts[2], Double.parseDouble(parts[3]), Integer.parseInt(parts[4]),
							Boolean.parseBoolean(parts[5]));
					vehicles.add(car);
				} else if (parts[0].equals("Bike") || parts[0].equals("bike")) {
					Bike bike = new Bike(parts[1], parts[2], Double.parseDouble(parts[3]),
							Boolean.parseBoolean(parts[4]), Integer.parseInt(parts[5]));
					vehicles.add(bike);
				}
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Error reading file");
		}
	}

	/**
	 * Add a vehicle to the vehicles list
	 * 
	 * @param vehicle The vehicle object
	 */
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}

	/**
	 * Display all the vehicle details
	 */
	public void displayVehicle() {
		System.out.printf("\nVehicle Data\n");
		for (Vehicle v : vehicles) {
			v.displayDetails();
			System.out.println("-----------");
		}
	}

	/**
	 * Searches if the specified brand or model is in the vehilces list
	 * 
	 * @param data Vehicle brand or model name
	 */
	public void searchByBrandOrModel(String data) {
		for (Vehicle v : vehicles) {
			if ((v.brand).equals(data) || (v.model).equals(data)) {
				System.out.println("Vehicle found");
				v.displayDetails();
			}
		}
	}

	/**
	 * Computes the total rental price of all vehicles together
	 */
	public void totalRentalPrice() {
		double sum = 0;
		for (Vehicle v : vehicles) {
			sum = sum + v.rentalPricePerDay;
		}
		System.out.println("Total rental price of all vehicles : " + sum);
	}

}
