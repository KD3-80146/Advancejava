package com.sunbeam.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.ReviewDaoImp;

@WebServlet("/canddel")
public class DeleteRecordServlent extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   doGet(req, resp);
	
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String candId = req.getParameter("id");
		
		int id = Integer.parseInt(candId);
		System.out.println(id);
		int cnt=0;
		try(ReviewDao rev = new ReviewDaoImp()){
			cnt=rev.deleteById(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(cnt);
		RequestDispatcher rs = req.getRequestDispatcher("myreview");
		rs.forward(req, resp);
	}

}
