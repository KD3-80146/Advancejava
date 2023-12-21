package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.ReviewDaoImp;
import com.sunbeam.pojos.Review;
import com.sunbeam.pojos.User;
@WebServlet("/myreview")
public class Myreview extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session =req.getSession();
		User curUser = (User) session.getAttribute("curUser");
		try(ReviewDao dao =new ReviewDaoImp()){
			List<Review> list =dao.findByUserId(curUser.getUserId());
			
			resp.setContentType("text/html");
			PrintWriter out= resp.getWriter();
		     
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Review Page</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<center>");
			out.printf("Hello  %s %s  <hr/>\r\n",curUser.getFirstName(),curUser.getLastName());
			out.print("<a href='review'>All Review</a> |");//All Review
			out.print("<a href='myreview'>MY Review</a> |");// my Review
			out.print("<a href='shared'>Shared Review</a> |");// Sheared Review
			out.println("<hr/>");
			out.println("<h3>All Reviews</h3>");
			out.println("<table border=1>");
			out.println("<thead>");
			out.println("<th>Movie ID</th>");
			out.println("<th>Review</th>");
			out.println("<th>Rating</th>");
			out.println("<th>User Id</th>");
			out.println("<th>Modified</th>");
			out.println("<th></th>");
			out.println("</thead>");
			out.println("<tbody>");
			for(Review r : list)
			{
				out.println("<tr>");
				out.printf("<td>%s</td>\r\n",r.getMovieId());
				out.printf("<td>%s</td>\r\n",r.getReview());
				out.printf("<td>%s</td>\r\n",r.getRating());
				out.printf("<td>%s</td>\r\n",r.getUserId());
				out.printf("<td>%s</td>\r\n",r.getModified());
				
				out.printf("<td><a href='candedit?id=%s'><img src='share2.png' alt='Edit' width='24' height='24'/></a><a href='candedit?id=%s'><img src='edit.png' alt='Edit' width='24' height='24'/></a> <a href='canddel?id=%s'><img src='delete.png' alt='Delete' width='24' height='24'/></a></td>\r\n", r.getReviewId(), r.getReviewId(),r.getReviewId());
				
				out.println("</tr>");
				
			}
			
			out.println("</tbody>");
			out.println("</table>");
			out.println("<a href='addreview'>Add Review</a>");//All movie
			out.println("<a href='signout'>Sign Out</a>");//sign out
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
		
		
	}

