package com.app.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Department;

@Repository //to tell sc  following is a spring bean  container data access logic
//mendatory cls level annotation to tell sc

public class DepartmentDaoImpl implements DepartmentDao {
    //sessionFactory 
	
	@Autowired//bytype using field level DI
	 private  SessionFactory session;
	@Override
	
	public List<Department> listAllDepartment() {
	       String jpql="select d from Department d";
		return session.getCurrentSession()
				.createQuery(jpql,Department.class)
				.getResultList();
	}

}
