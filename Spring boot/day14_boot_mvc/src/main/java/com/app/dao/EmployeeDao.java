package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
//list all emps by specific dept id : derived finder method
	// dept : name of the property in Emp pojo -> 
	//dept ref --> id : name of the
	// property inherited from BaseEntity
	//JPQL : select e from Employee e where e.dept.id=:id
	List<Employee> findByDeptId(Long departmentId);
}
