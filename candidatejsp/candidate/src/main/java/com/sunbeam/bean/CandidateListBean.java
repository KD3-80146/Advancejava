package com.sunbeam.bean;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class CandidateListBean {
      private List<Candidate> candList;
      
      public CandidateListBean() {
		this.candList=new ArrayList<Candidate>();
	}

      
	public List<Candidate> getCandList() {
		return candList;
	}


	public void setCandList(List<Candidate> candList) {
		this.candList = candList;
	}


	public void fetchCandidateDetail()
	{
		try(CandidateDao candDao = new CandidateDaoImpl())
		{
			this.candList =candDao.findAll();			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
      
}
