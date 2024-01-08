package com.sunbeam.main;
import java.util.List;

import com.sunbeam.dao.moviedao.MovieDao;
import com.sunbeam.pojo.Movie;


public class MainClass {

	public static void main(String[] args) {
		
//		try(MovieDao M= new MovieDao()){
//			List<Movie> list=M.findAll();
//			list.forEach(e->System.out.println(e));
//		}catch (Exception e) {
//		  e.printStackTrace();
//		}
		
		
		try(MovieDao m= new MovieDao()){
			
			Movie movie=m.findById(1);
			  System.out.println(movie.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
