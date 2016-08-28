package com.nurseaid.service;

import java.util.ArrayList;

import com.nurseaid.model.User;

public class CustomerService implements CustomerManager{
	
	private ArrayList<User> users = new ArrayList();
	
	public void addCustomerToList(User u)
	{
		this.users.add(u);
	}
	
	public User createCustomer(String uname)
	{
		User u1 = new User();
		u1.setUserName(uname);
		return u1;
	}
	
	public ArrayList getAllCustomers()
	{
		return this.users;
	}
	
	
}
