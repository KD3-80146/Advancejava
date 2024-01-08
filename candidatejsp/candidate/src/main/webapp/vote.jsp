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
   Hello ,${lb.user.firstName} ${lb.user.lastName} <hr/>
   <jsp:useBean id="vb" class="com.sunbeam.bean.VoteBean"></jsp:useBean>
   <jsp:setProperty property="candId" name="vb" param="candidate"/>
   <jsp:setProperty property="userId" name="vb" value="${lb.user.id}"/>
   ${vb.registerVote()}
   <h4>${vb.message}</h4>
   <a href="logout.jsp"> Sign Out</a>
</body>
</html>