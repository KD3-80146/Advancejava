package com.app.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.pojos.Player;
import com.app.pojos.Team;
import static  utils.HibernateUtils.getFactory;



public class PlayerDaoImpl implements PlayerDao {

	@Override
	public int addPlayer(Integer team_id , Player newPlayer) {
	       int count=0;
		  Session session=getFactory().getCurrentSession();
		  Transaction tx=session.beginTransaction();
		  try {
			  Team team=session.get(Team.class,team_id);
			 if(team!=null)
			 {
				 team.addPlayer(newPlayer);
			 }
			   count++;
			  tx.commit();
		  }catch (RuntimeException e) {
			  if(tx!=null)
				  tx.rollback();
			  throw e;
		}
		return count;
	}

}
