package com.litmus7.userregistration.ui;

import java.sql.*;
import java.util.*;

import com.litmus7.userregistration.controller.UserRegistrationController;
import com.litmus7.userregistration.model.Response;
import com.litmus7.userregistration.model.User;
import com.litmus7.userregistration.services.UserRegistrationService;
import com.litmus7.userregistration.util.DatabaseConnection;

public class UserRegistrationApp {
	public static void main(String args[]) {
		int choice;
		do {
			Scanner scan = new Scanner(System.in);
			System.out.printf("\n1.Register User\n2.View Users\n3.Delete User\n4.Exit\nEnter choice : ");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				addUser();
				break;
			case 2:
				viewUsers();
				break;
			case 3:
				deleteUser();
				break;
			case 4:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice, try again...");
				continue;
			}
		} while (choice != 4);

	}

	private static void addUser() {
		String name, email, password;
		int age;
		UserRegistrationController userRegistrationController = new UserRegistrationController();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter name : ");
		name = scan.next();
		System.out.println("Enter age : ");
		age = scan.nextInt();
		System.out.println("Enter email : ");
		email = scan.next();
		System.out.println("Enter password : ");
		password = scan.next();
		User user = new User(name, age, email, password);
		Response response = userRegistrationController.registerUser(user);
		if (response.getStatusCode() == 400) {
			System.out.println("Error adding user");
		}
	}

	private static void viewUsers() {
		UserRegistrationService userRegistrationService = new UserRegistrationService();
		Response response = userRegistrationService.viewUsers();
		if (response.getStatusCode() == 200) {
			System.out.println("Displayed the active users list");
		}
	}

	private static void deleteUser() {
		String name;
		Scanner scan = new Scanner(System.in);
		UserRegistrationController userRegistrationController = new UserRegistrationController();
		System.out.println("Enter name of user to delete : ");
		name = scan.next();
		Response response = userRegistrationController.deleteUser(name);
		if (response.getStatusCode() == 400) {
			System.out.println("Unable to delete user");
		}
	}

}
