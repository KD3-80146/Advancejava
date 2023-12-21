package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.chrono.AbstractChronology;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.MovieDaoImp;
import com.sunbeam.dao.MoviesDao;
import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.ReviewDaoImp;
import com.sunbeam.pojos.Movie;
import com.sunbeam.pojos.Review;
import com.sunbeam.pojos.User;

@WebServlet("/addreview")
public class AddReview extends HttpServlet {
	 List<Movie> list =null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     PrintWriter out=resp.getWriter();
	     out.println("<html>");
	     out.println("<head>");
	     out.println("<title>Add Review</title>");
	     out.println("</head>");
	     out.println("<body>");
	     out.println("<form method='post' action='addreview'>");
	     
	     try(MoviesDao movie =new MovieDaoImp())
	     {
	    	 list=movie.findAll();
	    	 
	     }catch (Exception e) {
			e.printStackTrace();
		}
	     out.println("<select name ='movie'>");
	     for(Movie m :list)
	     {  
	    	  out.printf("<option value='%d'>%s</option>",m.getMovieId(), m.getTitle()); 
	     }
	     out.println("</select>");
	     out.println("<br/>");
	     out.println("Rating :<input type='number' name='rating' value='rating'/><br/>");
	     out.println("Review :<input type='text' name='review' /><br/>");
	     out.println("<input type='submit' value='addreview'/> <br/>");
	     out.println("</form>");
	     out.println("</body>");
	     out.println("</html>");
	     
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session =req.getSession();
		User curUser = (User) session.getAttribute("curUser");
		
		int movie=Integer.parseInt(req.getParameter("movie"));
		int rating= Integer.parseInt(req.getParameter("rating"));
		int user_id=curUser.getUserId();
		String review=req.getParameter("review");
		
	    Review r = new Review(0, movie, review, rating, user_id, "");
	    
		try(ReviewDao rev=new ReviewDaoImp())
		{
		  int ctn=rev.save(r);
		  
		  if(ctn>0)
		  {
			  RequestDispatcher rd = req.getRequestDispatcher("review"); 
				rd.forward(req, resp);
		  }
		  else {
			  RequestDispatcher rd = req.getRequestDispatcher("addreview"); 
				rd.forward(req, resp);
		  }
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	

}
