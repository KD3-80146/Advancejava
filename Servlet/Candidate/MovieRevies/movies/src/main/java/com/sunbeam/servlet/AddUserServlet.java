package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImp;
import com.sunbeam.pojo.User;

@WebServlet("/Signup")
public class AddUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String first_name=req.getParameter("fname");
		String last_name=req.getParameter("lname");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String mobile=req.getParameter("number");
		String dob=req.getParameter("dob");
		System.out.println(first_name);
		User u= new User(first_name, last_name, email, password, mobile, dob);
		System.out.println(u);
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<Html>");
		out.println("<head>");
		out.println("<title>Register<title>");
		out.println("</head>");
		out.println("<body>");
		try(UserDao udao= new UserDaoImp()){
	          udao.save(u);

		}catch (Exception e) {
			e.printStackTrace();
		}
		out.println("<h5>Uesr Addaded.</h5>");
		out.println("<a href='index.html'>Sign in</a>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	   
	
}
