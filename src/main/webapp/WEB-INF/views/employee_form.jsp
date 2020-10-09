<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
</head>
<meta charset="ISO-8859-1">
<title>Employee Form</title>
<body>
<h2>Add Employee to payroll</h2>

	<form action="addEmployee" method="post">

		<div>
			Employee ID : <input type="text" name="empID">
		</div>
		<div>
			Name : <input type="text" name="name">
		</div>
		<div>
			Salary : <input type="text" name="salary">
		</div>
			<input type="submit" value="Add Employee">
	</form>
<br>
<h3>Employee Payroll</h3>
	<div>
		<c:if test="${!empty employees}">


			<table>
				<thead>
					<tr>
						<td>Name</td>
						<td>ID</td>
						<td>salary</td>
						<td>Action</td>
					</tr>
				</thead>
				<c:forEach items="${employees}" var="emp">

					<tr>
						<td>${emp["name"]}</td>
						<td>${emp.empID}</td>
						<td>${emp.salary}</td>
						<td><a href="removeemployee?empID=${emp.empID}">Delete</a>
						<td><a href="update?empID=${emp.empID}">Update</a>
					</tr>

				</c:forEach>
			</table>

		</c:if>
		
		<c:if test="${empty employees}">
			<h4>No Employee in Database</h4>
		</c:if>

	</div>
</body>
</html>