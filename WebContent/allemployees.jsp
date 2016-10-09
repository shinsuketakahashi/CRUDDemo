<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pactera Employee List</title>
</head>
<body>
	<div><img src="images/LOGO.jpeg" style="width:200px;height:50px;"></div>
	<br>
	<table border='1'>
		<thead>
			<tr>
				<th>Employee ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Department</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${employees}" var="employee">
			<tr>
				<td><c:out value="${employee.employeeID}" /></td>
				<td><c:out value="${employee.firstName}" /></td>
				<td><c:out value="${employee.lastName}" /></td>
				<td><c:out value="${employee.department}" /></td>
				<td><a href="EmployeeController?action=edit&employeeID=<c:out value="${employee.employeeID}"/>">Edit</a></td>
				<td><a href="EmployeeController?action=delete&employeeID=<c:out value="${employee.employeeID}"/>">Delete</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="EmployeeController?action=add">Add employee</a>
	</p>
</body>
</html>