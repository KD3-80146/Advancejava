<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--import spring supplied JSP tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
</head>
<body>
	<h5 align="center">${sessionScope.mesg}</h5>
	<table style="background-color: lightgrey; margin: auto">
		<caption>List Of Emps from Dept ${param.deptId}</caption>
		<c:forEach var="emp" items="${requestScope.emp_list}">
			<tr>

				<td>${emp.id}</td>
				<td>${emp.firstName}</td>
				<td>${emp.lastName}</td>
				<td>${emp.joinDate}</td>
				<td>${emp.salary}</td>
				<spring:url var="url" value="/emps/delete?empId=${emp.id}" />
				<td><a href="${url}">Delete</a></td>
				<spring:url var="url" value="/emps/update?empId=${emp.id}" />
				<td><a href="${url}">Update</a></td>
			</tr>
		</c:forEach>
	</table>
	<spring:url var="url" value="/emps/add" />
	<h4 align="center">
		<a href="${url}">Add New Employee</a>
	</h4>
	<h4 align="center">
		<a href="<spring:url value='/departments/list'/>">Back To
			Department List</a>
	</h4>


	<%--remove mesg from session scope --%>
	<c:remove var="mesg" scope="session" />
</body>
</html>