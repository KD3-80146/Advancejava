<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <jsp:useBean id="play" class="com.app.bean.SendDataBeam"></jsp:useBean>
  <jsp:setProperty property="*" name="play"/>
   ${play.addPlayer()}
   <a href="add_player_form.jsp">Add more Player</a>
</body>
</html>