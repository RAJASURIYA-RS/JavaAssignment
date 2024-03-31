package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.model.Customer;
import com.service.CustomerService;

public class CustomerController {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		Scanner sc = new Scanner(System.in);

		while (true) {
			while (true) {
				System.out.println("*********CUSTOMER OPS**********");
				System.out.println("Press 1. To get Customer Details");
				System.out.println("Press 2. To update Customer Details");
				System.out.println("Press 0 for exit");
				System.out.println("****************************");
				int input = sc.nextInt();
				if (input == 0) {
					System.out.println("Exiting.. thank you!!!");
					break;
				} // if ends
				switch (input) {
				case 1:
					List<Customer> list = new ArrayList<>();
					try {
						list = customerService.getCustomerDetails();
						for (Customer c : list) {
							System.out.println(c);
						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 2:
					System.out.println("Update the Customer Details:");
					System.out.println("Enter Customer id");
					int id = sc.nextInt();
					System.out.println("Enter updated email");
					sc.nextLine();
					String email = sc.nextLine();
					System.out.println("Enter updated phone number");
					String phone = sc.nextLine();
					System.out.println("Enter updated address");
					String address = sc.nextLine();
					try {
						customerService.updateCustomer(id, email, phone, address);
						System.out.println("Customer Record Updated");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					break;
				}

			}
			sc.close();
		}
	}
}
