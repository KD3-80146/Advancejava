package com.sunbeam.bean;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class DeleteCandidateBean {
    private int candId;
    private String message;
    
	public DeleteCandidateBean() {
		
	}
	public int getCandId() {
		return candId;
	}
	public void setCandId(int candId) {
		this.candId = candId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
    
	public void deleteCandidate()
	{
		try(CandidateDao cDao=new CandidateDaoImpl()){
			int count=cDao.deleteById(candId);
			this.message="Candidate Deleted" + count;
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    
    
    
}

