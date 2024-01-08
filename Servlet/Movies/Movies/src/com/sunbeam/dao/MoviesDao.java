package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.pojo.Movie;

public interface MoviesDao extends AutoCloseable {
     
	public List<Movie> findAll() throws Exception;
	 public Movie findById(int id) throws Exception;
}
