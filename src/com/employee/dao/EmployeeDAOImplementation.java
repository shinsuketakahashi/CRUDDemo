package com.employee.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.employee.model.Employee;
import com.employee.utils.DBUtil;

public class EmployeeDAOImplementation implements EmployeeDAO{

	private Connection conn;
	
	public EmployeeDAOImplementation(){
		conn = DBUtil.getConnection();
	}
	
	@Override
	public Employee getEmployeeInfo(int employeeID) {
		Employee emp = new Employee();
		try{
			String query = "SELECT * FROM employee WHERE EmployeeID = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, employeeID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				emp.setEmployeeID(rs.getInt("EmployeeID"));
				emp.setFirstName(rs.getString("FirstName"));
				emp.setLastName(rs.getString("LastName"));
				emp.setDepartment(rs.getString("Department"));
			}
			rs.close();
			ps.close();
		}catch (SQLException SQLe){
			SQLe.printStackTrace();
		}
		return emp;
	}

	@Override
	public void addEmployee(Employee employee) {
		try{
			String query = "INSERT INTO employee (FirstName, LastName, Department) values (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setString(3, employee.getDepartment());
			ps.executeUpdate();
			ps.close();
		}catch (SQLException SQLe){
			SQLe.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(int employeeID) {
		try{
			String query = "DELETE FROM employee WHERE EmployeeID = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, employeeID);
			ps.executeUpdate();
			ps.close();
		}catch (SQLException SQLe){
			SQLe.printStackTrace();
		}
		
	}

	@Override
	public void editEmployee(Employee employee) {
		try{
			String query = "UPDATE employee SET FirstName = ?, LastName = ?, Department = ? WHERE EmployeeID = ? ";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setString(3, employee.getDepartment());
			ps.setInt(4, employee.getEmployeeID());
			ps.executeUpdate();
			ps.close();
		}catch (SQLException SQLe){
			SQLe.printStackTrace();
		}
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		try{
			String query = "SELECT * FROM employee";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				Employee emp = new Employee();
				emp.setEmployeeID(rs.getInt("EmployeeID"));
				emp.setFirstName(rs.getString("FirstName"));
				emp.setLastName(rs.getString("LastName"));
				emp.setDepartment(rs.getString("Department"));
				employees.add(emp);
			}
			rs.close();
			statement.close();
		}catch (SQLException SQLe){
			SQLe.printStackTrace();
		}
		return employees;
	}

	
}
