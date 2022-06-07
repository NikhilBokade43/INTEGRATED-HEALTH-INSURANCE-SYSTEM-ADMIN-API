package com.nikhil.service;

import java.util.List;

import com.nikhil.Entity.CaseWorkerAccount;


public interface CaseWorkerAccountInterface {
	
	
	public String createAccount(CaseWorkerAccount accountForm);
	public List<CaseWorkerAccount> viewAccounts();
	public CaseWorkerAccount editCaseWorkerAcc(Integer accountId);
	public String hardDeleteCaseWorkerAcc(Integer accountId);
	public String softDeleteCaseWorkerAcc(Integer accountId);
	

}
