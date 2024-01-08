<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--import spring supplied JSP tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Emp List</title>
</head>
<body>
	<form method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Emp Id </td>
				<td><input type="number" name="empId" readonly
					value="${param.empId}" /></td>
			</tr>
			<tr>
				<td>Enter Salary</td>
				<td><input type="number" name="salary" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update Emp Salary" /></td>
			</tr>
		</table>
	</form>

</body>
</html>