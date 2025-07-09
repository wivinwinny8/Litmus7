package com.litmus7.userregistration.services;

import com.litmus7.userregistration.exceptions.DuplicateUserException;
import com.litmus7.userregistration.exceptions.UserNotFoundException;
import com.litmus7.userregistration.model.Response;
import com.litmus7.userregistration.model.User;
import com.litmus7.userregistration.util.DatabaseConnection;

import java.sql.*;

public class UserRegistrationService {

	public Response addUser(User user) {
		Response serviceResponse = new Response();
		try {
			Connection con = DatabaseConnection.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from userdata");
			while (rs.next()) {
				if (rs.getString(1).equals(user.getUsername())) {
					throw new DuplicateUserException("User already exist");
				}
			}
			PreparedStatement preparedStm = con
					.prepareStatement("insert into userdata(name,age,email,password) values(?,?,?,?)");
			preparedStm.setString(1, user.getUsername());
			preparedStm.setInt(2, user.getAge());
			preparedStm.setString(3, user.getEmail());
			preparedStm.setString(4, user.getPassword());
			int count = preparedStm.executeUpdate();
		} catch (DuplicateUserException e) {
			System.out.println("Error : " + e);
			serviceResponse.setStatusCode(400);
			serviceResponse.setErrorMessage("Duplicate user");

		} catch (SQLException e) {
			System.out.println("Error : " + e);
			serviceResponse.setStatusCode(400);
			serviceResponse.setErrorMessage("SQL connection error");

		}
		return serviceResponse;

	}

	public Response viewUsers() {
		Response serviceResponse = new Response();
		try {
			Connection con = DatabaseConnection.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from userdata");
			boolean isEmpty = (!rs.next());
			System.out.println("Available User Data");
			if (isEmpty) {
				System.out.println("No data to show");
			} else {
				do {
					System.out.printf("\nName : " + rs.getString(1) + "\nAge : " + rs.getInt(2) + "\nEmail : "
							+ rs.getString(3) + "\nPassword : " + rs.getString(4) + "\n");
				} while (rs.next());
			}
		} catch (SQLException e) {
			System.out.println("Error : " + e);
			serviceResponse.setStatusCode(400);
			serviceResponse.setErrorMessage("SQL connection error");
		}
		return serviceResponse;
	}

	public Response deleteUser(String name) {
		Response response = new Response();
		try {
			int flag = 0;
			Connection con = DatabaseConnection.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from userdata");
			while (rs.next()) {
				if (rs.getString(1).equals(name)) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				throw new UserNotFoundException("User " + name + " doesnt exist");
			} else {
				PreparedStatement preparedStm = con.prepareStatement("delete from userdata where name=?");
				preparedStm.setString(1, name);
				int count = preparedStm.executeUpdate();
				if (count < 1) {
					response.setStatusCode(400);
					response.setErrorMessage("Unable to delete");
				}
			}
		} catch (UserNotFoundException e) {
			response.setStatusCode(400);

			response.setErrorMessage("Unable to delete");
			System.out.println("Error : " + e);
		} catch (Exception e) {
			response.setStatusCode(400);
			response.setErrorMessage("Unable to delete");
			System.out.println("Error : " + e);
		}

		return response;

	}
}
