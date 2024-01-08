<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      hello , ${lb.user.firstName} ${lb.user.lastName} <hr/>
      
      <jsp:useBean id="uc" class="com.sunbeam.bean.FindCandidateBean"></jsp:useBean>
      <jsp:setProperty property="candId" name="uc" param="id"/>
      ${uc.fetchCandidate()}
      <form method="post" action ="updatecand.jsp">
        <input type="hidden" name="id" value="${uc.candidate.id}"/> <br/><br/>
       Name: <input type="text" name="name" value="${uc.candidate.name}"/> <br/><br/>
       Party: <input type="text" name="party" value="${uc.candidate.party}"/> <br/><br/>
       Votes: <input type="text" name="votes" value="${uc.candidate.votes}" readonly/> <br/><br/>
         <input type="submit" value="Update Candidate"/>
      </form>
      
</body>
</html>