<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">-->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
	<form action="EmployeeController" method="post">
		<fieldset>
			<legend>Employee Details:</legend>
			<div>
				<label for="employeeID">Employee ID:</label><input type="text" name="employeeID" value="<c:out value="${employee.employeeID}"/>" readonly="readonly" placeholder="Employee ID" />
			</div>
			<div>
				<label for="firstname">First Name:</label><input type="text" name="firstname" value="<c:out value="${employee.firstName}"/>" placeholder="First Name" />
			</div>
			<div>
				<label for="lastname">Last Name:</label><input type="text" name="lastname" value="<c:out value="${employee.lastName}"/>" placeholder="Last Name" />
			</div>
			<div>
				<label for="department">Department:</label><input type="text" name="department" value="<c:out value="${employee.department}"/>" placeholder="Department" />
			</div>
			<div>
                <input type="submit" value="Submit" />
            </div>
		</fieldset>
	</form>
</body>
</html>