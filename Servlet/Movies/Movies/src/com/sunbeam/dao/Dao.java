package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.sunbeam.dbutil.Dbutil;

public class Dao implements AutoCloseable {

	protected Connection con;
	public Dao() throws SQLException {
		con=Dbutil.getConnection();
	}
	@Override
	public void close() throws Exception {
		
	try {
		if(con!=null)
		{
			con.close();
		}
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
	
}
