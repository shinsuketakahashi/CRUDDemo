package com.employee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.model.Employee;
import com.employee.dao.EmployeeDAO;
import com.employee.dao.EmployeeDAOImplementation;

@WebServlet("/EmployeeController")
public class EmployeeControllerServlet extends HttpServlet{
	
	private EmployeeDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String LIST_ALL_EMPLOYEES = "/allemployees.jsp";
    public static final String ADD_OR_EDIT = "/employee.jsp";
    
    public EmployeeControllerServlet(){
    	dao = new EmployeeDAOImplementation();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String forward = "";
    	String action = request.getParameter("action");
    	
    	if(action.equalsIgnoreCase("add")){
    		forward = ADD_OR_EDIT;
    	}else if(action.equalsIgnoreCase("edit")){
    		forward = ADD_OR_EDIT;
    		int employeeID = Integer.parseInt(request.getParameter("employeeID"));
    		Employee emp = dao.getEmployeeInfo(employeeID);
    		request.setAttribute("employee", emp);
    	}else if(action.equalsIgnoreCase("delete")){
    		forward = LIST_ALL_EMPLOYEES;
    		int employeeID = Integer.parseInt(request.getParameter("employeeID"));
    		dao.deleteEmployee(employeeID);
    		
    		List<Employee> employeeList = dao.getAllEmployees();
    		request.setAttribute("employees", employeeList);
    	}else{
    		forward = LIST_ALL_EMPLOYEES;
    		List<Employee> employeeList = dao.getAllEmployees();
    		request.setAttribute("employees", employeeList);
    	}
    	
    	RequestDispatcher rd = request.getRequestDispatcher(forward);
    	rd.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	Employee emp = new Employee();
    	String employeeID = request.getParameter("employeeID");
    	emp.setFirstName(request.getParameter("firstname"));
    	emp.setLastName(request.getParameter("lastname"));
    	emp.setDepartment(request.getParameter("department"));
    	
    	if(emp == null || employeeID.isEmpty()){
    		dao.addEmployee(emp);
    	}else{
    		emp.setEmployeeID(Integer.parseInt(employeeID));
    		dao.editEmployee(emp);
    	}
    	RequestDispatcher rd = request.getRequestDispatcher(LIST_ALL_EMPLOYEES);
    	List<Employee> employeeList = dao.getAllEmployees();
    	request.setAttribute("employees", employeeList);
    	rd.forward(request, response);
    }
}
