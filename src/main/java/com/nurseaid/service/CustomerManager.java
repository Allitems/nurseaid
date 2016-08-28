package com.nurseaid.service;

import java.util.ArrayList;

import com.nurseaid.model.User;

public interface CustomerManager {
	public void addCustomerToList(User u);
	public User createCustomer(String uname);
	public ArrayList getAllCustomers();
}
