package com.employee.model;

public class Employee {

	private int employeeID;
	private String firstName;
	private String lastName;
	private String department;
	
	//employeeID
	public void setEmployeeID(int employeeID){
		this.employeeID = employeeID;
	}
	
	public int getEmployeeID(){
		return employeeID;
	}
	
	
	//firstName
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	//lastName
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	//Department
	public void setDepartment(String department){
		this.department = department;
	}
	
	public String getDepartment(){
		return department;
	}
	
	@Override
	public String toString(){
		return "Employee = [EmployeeID:" + this.employeeID + "; FirstName:" + this.firstName + "; LastName:" + this.lastName + "; Department:" + this.department + "]" ;
	}
	
}
