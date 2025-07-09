package com.litmus7.userregistration.controller;

import com.litmus7.userregistration.exceptions.InvalidAgeException;
import com.litmus7.userregistration.exceptions.InvalidEmailException;
import com.litmus7.userregistration.exceptions.InvalidUserNameException;
import com.litmus7.userregistration.exceptions.WeakPasswordException;
import com.litmus7.userregistration.model.Response;
import com.litmus7.userregistration.model.User;
import com.litmus7.userregistration.services.UserRegistrationService;

public class UserRegistrationController {
	public Response registerUser(User user) {
		String username, email, password;
		int age;
		Response controllerResponse = new Response();
		UserRegistrationService userRegistrationService = new UserRegistrationService();
		controllerResponse.setStatusCode(200);
		if (user == null) {
			controllerResponse.setStatusCode(400);
			controllerResponse.setErrorMessage("No user");

			return controllerResponse;
		}
		username = user.getUsername();
		age = user.getAge();
		email = user.getEmail();
		password = user.getPassword();
		try {
			if (username == "") {
				throw new InvalidUserNameException("Username cannot be null");
			}
			if (age > 60 || age < 18) {
				throw new InvalidAgeException("Age must be between 18 and 60");
			}
			if (!(email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"))) {
				throw new InvalidEmailException("Email format is invalid");
			}
			if ((password.length()) < 6) {
				throw new WeakPasswordException("Password must have minimum 6 characters");
			}
		} catch (InvalidUserNameException | InvalidAgeException | InvalidEmailException | WeakPasswordException e) {
			controllerResponse.setStatusCode(400);
			controllerResponse.setErrorMessage("Input error");

			System.out.println("Error : " + e);
		}
		if (controllerResponse.getStatusCode() == 200) {
			Response serviceResponse = new Response();
			serviceResponse = userRegistrationService.addUser(user);
			if (serviceResponse.getStatusCode() == 200) {
				System.out.println("User successfully registered.");
			}
		}
		return controllerResponse;
	}

	public Response deleteUser(String name) {
		Response controllerResponse = new Response();
		try {
			if (name == "") {
				throw new InvalidUserNameException("Username cannot be null");

			}
		} catch (InvalidUserNameException e) {
			controllerResponse.setStatusCode(400);
			controllerResponse.setErrorMessage("Null username");

		}
		if (controllerResponse.getStatusCode() == 200) {
			Response serviceResponse = new Response();
			UserRegistrationService userRegistrationService = new UserRegistrationService();
			serviceResponse = userRegistrationService.deleteUser(name);
			if (serviceResponse.getStatusCode() == 200) {
				System.out.println("User " + name + " deleted");
			}
		}
		return controllerResponse;

	}
}
