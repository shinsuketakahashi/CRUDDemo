package com.employee.dao;

import com.employee.model.Employee;
import java.util.List;

public interface EmployeeDAO {

	public Employee getEmployeeInfo(int employeeID);
	public void addEmployee(Employee employee);
	public void deleteEmployee(int employeeID);
	public void editEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	
}
