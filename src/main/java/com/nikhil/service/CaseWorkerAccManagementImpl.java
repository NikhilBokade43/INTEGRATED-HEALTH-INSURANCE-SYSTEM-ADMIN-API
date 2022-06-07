package com.nikhil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikhil.Entity.CaseWorkerAccount;

import com.nikhil.Repository.CaseWorkerAccountRepo;
import com.nikhil.service.CaseWorkerAccountInterface;

@Service
public class CaseWorkerAccManagementImpl implements CaseWorkerAccountInterface {
	
	@Autowired
	private CaseWorkerAccountRepo caseWorkerRepo;


	@Override
	public String createAccount(CaseWorkerAccount accountForm) {
		accountForm.setActiveSW("Y");
		CaseWorkerAccount accountSaved = caseWorkerRepo.save(accountForm);
		if(accountSaved.getFullName() != null && accountSaved.getFullName() != "") {
			return "SUCCESS";
		}
		return "FAILED TO SAVE DATA";
	}

	@Override
	public List<CaseWorkerAccount> viewAccounts() {
		return caseWorkerRepo.findAll();
	}

	@Override
	public CaseWorkerAccount editCaseWorkerAcc(Integer accountId) {
		Optional<CaseWorkerAccount> optional = caseWorkerRepo.findById(accountId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public String hardDeleteCaseWorkerAcc(Integer accountId) {
		caseWorkerRepo.deleteById(accountId);
		return "SUCCESS";
	}

	@Override
	public String softDeleteCaseWorkerAcc(Integer accountId) {
		Optional<CaseWorkerAccount> optional = caseWorkerRepo.findById(accountId);
		if(optional.isPresent()) {
			CaseWorkerAccount entity = optional.get();
			entity.setActiveSW("N");
			return "SUCCESS";
		}
		return null;
	}

}

