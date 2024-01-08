package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class First extends HttpServlet {
	private String color = "";
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		color = config.getInitParameter("color");
		System.out.println("SecondServlet.init() called.");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SecondServlet.doGet() called.");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello DAC</title>");
		out.println("</head>");
		color = this.getInitParameter("color");
		out.printf("<body bgcolor='%s'>\r\n", color);
		out.println("<h3>Welcome to Java EE Servlets</h3>");
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	public void destroy() {
		System.out.println("SecondServlet.destroy() called.");
	
}
}
