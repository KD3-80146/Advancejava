package com.sunbeam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojo.Review;

public class ReviewDaoImp extends Dao implements ReviewDao{

	public ReviewDaoImp() throws SQLException {
		
	}
	
	@Override
	public int save(Review r) throws Exception {
		int count=0;
		String sql="insert into reviews values(default,?,?,?,?,?)";
		try(PreparedStatement ps =con.prepareStatement(sql))
		{
			ps.setInt(1,r.getMovie_id());
			ps.setString(2, r.getReview());
			ps.setInt(3, r.getRating());
			ps.setInt(4, r.getUser_id());
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date date = sdf.parse(r.getModified());
			java.sql.Date sDate = new java.sql.Date( date.getTime() );
			ps.setDate(5, sDate);
	        count=ps.executeUpdate();
		


			
		}
		return count;
	}

	@Override
	public int update(Review r) throws Exception {
		int count=0;
		String sql="update reviews set movie_id=? ,review=?,rating=?,user_id=?, modified =? where review_id=?";
		try(PreparedStatement ps=con.prepareStatement(sql)){
			ps.setInt(1, r.getMovie_id());
			ps.setString(2, r.getReview());
			ps.setInt(3, r.getRating());
			ps.setInt(4, r.getUser_id());
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date date = sdf.parse(r.getModified());
			java.sql.Date sDate = new java.sql.Date( date.getTime() );
			ps.setDate(5, sDate);
			ps.setInt(6, r.getReview_id());
			count=ps.executeUpdate();
		}
		
		return count;
	}

	@Override
	public List<Review> findAll() throws Exception {
		List<Review> list=new ArrayList<Review>();
		String sql="select * from reviews order by DESC";
		try(PreparedStatement ps=con.prepareStatement(sql)){
			try(ResultSet rs=ps.executeQuery()){
				while(rs.next())
				{
					int review_id = rs.getInt("review_id");
					int movie_id = rs.getInt("movie_id");
					String review = rs.getString("review");
					int rating = rs.getInt("rating");
					int user_id = rs.getInt("user_id");
					java.sql.Date sDate = rs.getDate("modified");
	    			java.util.Date uDate = new java.util.Date( sDate.getTime());
				    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				    String str = sdf.format(uDate);
				    Review r = new Review(review_id, movie_id, review, rating, user_id, str);
				    list.add(r);
				}
			}
		}
		return list;
	}

	@Override
	public List<Review> findByUserId(int userId) throws Exception {
		List<Review> list = new ArrayList<Review>();
		 String sql="select * from reviews where user_id = ?";
		  try(PreparedStatement ps = con.prepareStatement(sql))
		  {
			  ps.setInt(1, userId);
			 try(ResultSet rs = ps.executeQuery())
			 {
				 while(rs.next())
					{
						int review_id = rs.getInt("review_id");
						int movie_id = rs.getInt("movie_id");
						String review = rs.getString("review");
						int rating = rs.getInt("rating");
						int user_id = rs.getInt("user_id");
						java.sql.Date sDate = rs.getDate("modified");
		    			java.util.Date uDate = new java.util.Date( sDate.getTime());
					    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					    String str = sdf.format(uDate);
					    Review r = new Review(review_id, movie_id, review, rating, user_id, str);
					    list.add(r);
					}
				 
			 }
		  }
		return list;
	}

	@Override
	public List<Review> getSharedWithUser(int userId) throws Exception {
		List<Review> list = new ArrayList<Review>();
		String sql = "SELECT r.* FROM reviews r INNER JOIN shares s ON r.id=s.review_id WHERE s.user_id=? ORDER BY modified DESC";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, userId);
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("review_id");
					int movieId = rs.getInt("movie_id");
					String review = rs.getString("review");
					int rating = rs.getInt("rating");
					int user_Id = rs.getInt("user_id");
					java.sql.Date sDate = rs.getDate("modified");
	    			java.util.Date uDate = new java.util.Date( sDate.getTime());
				    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				    String str = sdf.format(uDate);
					Review r = new Review(id, movieId, review, rating, user_Id, str);
					list.add(r);
				}
			} // rs.close();
		} // stmt.close();
		return list;
		
	}

	@Override
	public Review findById(int id) throws Exception {
		String sql = "SELECT * FROM reviews WHERE review_id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					id = rs.getInt("review_id");
					int movieId = rs.getInt("movie_id");
					String review = rs.getString("review");
					int rating = rs.getInt("rating");
					int usr_Id = rs.getInt("user_id");
					java.sql.Date sDate = rs.getDate("modified");
	    			java.util.Date uDate = new java.util.Date( sDate.getTime());
				    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				    String str = sdf.format(uDate);
					Review r = new Review(id, movieId, review, rating, usr_Id, str);
					return r;
				}
			} // rs.close();
		} // stmt.close();
		return null;
		
	}

	@Override
	public int deleteById(int reviewId) throws Exception {
		String sql = "DELETE FROM reviews WHERE review_id=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, reviewId);
			int count = stmt.executeUpdate();
			return count;
		}
	}

	@Override
	public int shareReview(int reviewId, int userId) throws Exception {
		String sql = "INSERT INTO shares(review_id, user_id) VALUES (?, ?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, reviewId);
			stmt.setInt(2, userId);
			int count = stmt.executeUpdate();
			return count;
		}
		catch (SQLIntegrityConstraintViolationException e) {
			// do nothing
		}
		return 0;
	}

}
