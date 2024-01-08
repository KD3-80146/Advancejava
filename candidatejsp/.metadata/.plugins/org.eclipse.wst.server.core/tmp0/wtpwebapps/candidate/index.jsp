<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div>
     <form method="post" action="login.jsp">
        Email : <input type="text"  name="email"/>
        Password: <input type ="password" name="password"/>
        <input type="submit" value="Sign in" />
        <a href="register.jsp" value="Signup" >SignUp</a>
     </form>
  </div>
</body>
</html>