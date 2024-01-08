<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <jsp:useBean id="ucb" class="com.sunbeam.bean.UpdateCandidateBean"></jsp:useBean>
   <jsp:setProperty property="*" name="ucb"/>
   ${ucb.updateRecord()}
   <jsp:forward page="result.jsp">
      <jsp:param value="${ucb.message}" name="ucbMessage"/>
   </jsp:forward>
</body>
</html>