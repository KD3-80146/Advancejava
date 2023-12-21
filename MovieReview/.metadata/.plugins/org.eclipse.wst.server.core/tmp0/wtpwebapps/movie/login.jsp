<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentication</title>
</head>
<body>
    <jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean"></jsp:useBean>
    <jsp:setProperty  property="email" name="lb" param="email"/>
    <jsp:setProperty  property="password" name="lb" param="password"/>
     <jsp:setProperty  property="status" name="lb" param="false"/>
     <%lb.authanticate();%>
     <%
        if(lb.getStatus())
        {
        	out.println("Welcome ,User");
        }
        else
        {
        	out.println("Invalid Login");	
        }
        %>
     
</body>
</html>