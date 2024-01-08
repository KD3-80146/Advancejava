package com.sunbeam.bean;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class FindCandidateBean {
	private int candId;
	private Candidate candidate;
	
	
	public FindCandidateBean() {
	}


	public int getCandId() {
		return candId;
	}


	public void setCandId(int candId) {
		this.candId = candId;
	}


	public Candidate getCandidate() {
		return candidate;
	}


	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
	public void fetchCandidate()
	{
		try(CandidateDao cDao=new CandidateDaoImpl())
		{
			System.out.println(candId);
			this.candidate=cDao.findById(candId);
			System.out.println(candidate);
			
		}catch (Exception e) {
	       e.printStackTrace();
		}
	}
	

}
