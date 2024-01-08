package com.app.dao;

import static com.app.utils.HibernateUtils.getFactory;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.pojos.Owner;

public class OwnerDaoImpl implements OwnerDao {

	@Override
	public String addownerDetail(Owner newOwner) {
		String mesg="Adding new owner failed!!!!!!!!";
		// 1. get session from SF
		Session session=getFactory().getCurrentSession();
		//2. begin a tx
		Transaction tx=session.beginTransaction();
		try {
			 Serializable OwnerId=session.save(newOwner);
			 mesg="Adding new owner id="+OwnerId;
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

	}
		 
		


