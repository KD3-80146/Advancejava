package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/candedit")
public class EditReviewSevlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session =req.getSession();
		User curUser = (User) session.getAttribute("curUser");
		
		int reviewId=Integer.parseInt(req.getParameter("reviewid"));
		int movieId= Integer.parseInt(req.getParameter("movieid"));
		String review=req.getParameter("review");
		int rating= Integer.parseInt(req.getParameter("rating"));
		int user_id=curUser.getUserId();
		Review r =new Review(reviewId, movieId, review, rating, user_id, "");
		try(ReviewDao rev= new ReviewDaoImp())
		{
			rev.update(r);
			
		}catch (Exception e) {
		    e.printStackTrace();
		}
		

		  RequestDispatcher rd = req.getRequestDispatcher("myreview"); 
		  rd.forward(req, resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session =req.getSession();
		User curUser = (User) session.getAttribute("curUser");
		int reviewId =Integer.parseInt( req.getParameter("id"));
		
		 Review r =null;
		try(ReviewDao rs= new ReviewDaoImp()){
			r=rs.findById(reviewId);
		}catch (Exception e) {
		    e.printStackTrace();
		}
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit Candidate</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h5>Edit Candidate</h5>");
		out.println("<form method='post' action='candedit'>");
		out.printf("Review Id: <input type='text' name='reviewid' value='%s' readonly>\r\n<br/>",r.getReviewId());
		out.printf("Movie Id: <input type='text' name='movieid' value='%s' readonly>\r\n<br/>",r.getMovieId());
		out.printf("Review : <input type='text' name='review' value='%s'>\r\n<br/>", r.getReview());
		out.printf("Rating : <input type='text' name='rating' value='%s'>\r\n<br/>", r.getRating());
		out.printf("User Id : <input type='text' name='Userid' value='%s' readonly>\r\n<br/>", r.getUserId());
		out.printf("modified : <input type='text' name='modified' value='%s' readonly>\r\n<br/>",r.getModified());
		out.println("<input type='submit' value='Update'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}
