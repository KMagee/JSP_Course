package com.luv2code.jsp.tagdemo;

public class Student {
	
	private String firstName;
	private String lastName;
	private boolean goldCustomer;
	
	
	//CONSTRUCTOR -- ALLOWS YOU TO SET VARIABLES AS SOON AS YOU CREATE AN OBJECT INSTANCE, INSIDE THE 
	//ARGUMENTS OF THE OBJECT 
	// student newStudent =  new Student(add the details here instead of using setters 
	public Student(String firstName, String lastName, boolean goldCustomer) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.goldCustomer = goldCustomer;
	}

	
	//GETTERS AND SETTERS

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public boolean isGoldCustomer() {
		return goldCustomer;
	}


	public void setGoldCustomer(boolean goldCustomer) {
		this.goldCustomer = goldCustomer;
	}
	
	
}
