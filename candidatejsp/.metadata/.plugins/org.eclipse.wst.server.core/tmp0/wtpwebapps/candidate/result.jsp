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
  Hello, ${lb.user.firstName} ${lb.user.lastName} <hr/>
	<jsp:useBean id="rb" class="com.sunbeam.bean.ResultBean"></jsp:useBean>
	${rb.fetchCandidateList()}
   <table border="1">
       <thead>
       <tr>
           <th>Id</th>
           <th>Name</th>
           <th>Party</th>
           <th>Vote</th>
           <th>Action</th>
      </tr>
       </thead>
       <tbody>
          <c:forEach var = "c" items="${rb.candList}">
           <tr>
              <td>${c.id}</td>
              <td>${c.name}</td>
              <td>${c.party}</td>
              <td>${c.votes}</td>
              <td>
                <a href="editcand.jsp?id=${c.id}">Edit</a>
			    <a href="delcand.jsp?id=${c.id}">Delete</a>
              </td>
          </tr>
          </c:forEach>
       </tbody>
   </table>
  <a href ="logout.jsp">Sign Out</a>
</body>
</html>