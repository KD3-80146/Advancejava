package com.sunbeam.bean;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class ResultBean {
    private List<Candidate> candList;
    
    public ResultBean() {
		this.candList=new ArrayList<Candidate>();
	}

	public List<Candidate> getCandList() {
		return candList;
	}

	public void setCandList(List<Candidate> candList) {
		this.candList = candList;
	}
    
	public void fetchCandidateList()
	{
		try(CandidateDao cDao= new CandidateDaoImpl())
		{
			candList =cDao.findAll();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
