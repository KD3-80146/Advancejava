package com.sunbeam.beans;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImp;
import com.sunbeam.pojos.User;

public class RegisterBeam {
  
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String mobile;
	private String dob;
	public RegisterBeam() {
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
    public int  addUser()
   {
    	int cnt=0;
    	User u= new User(0, firstName, lastName, email, password, mobile, dob);
    	System.out.println(u.toString());
    	try(UserDao udao =new UserDaoImp())
    	{
    		
    		 cnt= udao.save(u);
    		
    	}catch (Exception e) {
		  e.printStackTrace();
		}
	  return cnt;
   }
	
}
