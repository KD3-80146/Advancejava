package com.app.tester;
import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.OwnerDaoImpl;
import com.app.pojos.Owner;

public class TesterOwner {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		   try(SessionFactory session=getFactory()){
			   System.out.println("Enter the owner Detail :- FirstName LastName Email");
			   Owner owner=new Owner(sc.next(), sc.next(),sc.next());
			   OwnerDaoImpl dao=new OwnerDaoImpl();
			  String s= dao.addownerDetail(owner);
			  System.out.println(s);
		   }

	}

}
