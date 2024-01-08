package com.sunbeam.pojo;

import java.util.Date;

public class Movie {
   
	int movies_id;
	String tittle;
	String release_date;
	
	
	public Movie() {
		super();
	}


	public Movie(int movies_id, String tittle, String release_date) {
		super();
		this.movies_id = movies_id;
		this.tittle = tittle;
		this.release_date = release_date;
	}


	public int getMovies_id() {
		return movies_id;
	}


	public void setMovies_id(int movies_id) {
		this.movies_id = movies_id;
	}


	public String getTittle() {
		return tittle;
	}


	public void setTittle(String tittle) {
		this.tittle = tittle;
	}


	public String getRelease_date() {
		return release_date;
	}


	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}


	@Override
	public String toString() {
		return "Movie [movies_id=" + movies_id + ", tittle=" + tittle + ", release_date=" + release_date + "]";
	}
	 
}
