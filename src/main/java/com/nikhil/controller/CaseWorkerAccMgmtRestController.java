package com.nikhil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.Entity.CaseWorkerAccount;
import com.nikhil.service.CaseWorkerAccManagementImpl;

@RestController
public class CaseWorkerAccMgmtRestController {
	@Autowired
	private CaseWorkerAccManagementImpl service;

	@GetMapping("/caseworkerAcc/viewAllAcc")
	public ResponseEntity<List<CaseWorkerAccount>> viewAccounts() {
		List<CaseWorkerAccount> accountsList = service.viewAccounts();
		return new ResponseEntity<>(accountsList, HttpStatus.OK);
	}

	@PostMapping("/caseworkerAcc/create")
	public ResponseEntity<String> createAccount(@RequestBody CaseWorkerAccount accountForm) {
		String msg = "Account Created";
		String status = service.createAccount(accountForm);
		if (status.toLowerCase().equals("success")) {
			return new ResponseEntity<>(msg, HttpStatus.CREATED);
		} else
			return new ResponseEntity<String>("Failed", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/editAcc/{accountId}")
	public ResponseEntity<CaseWorkerAccount> editCaseWorkerAcc(@PathVariable Integer accountId) {
		CaseWorkerAccount acc = service.editCaseWorkerAcc(accountId);
		return new ResponseEntity<CaseWorkerAccount>(acc, HttpStatus.OK);
	}

	@GetMapping("/hardDeleteAcc/{accountId}")
	public ResponseEntity<String> hardDeleteCaseWorkerAcc(@PathVariable Integer accountId) {
		String msg = service.hardDeleteCaseWorkerAcc(accountId);
		if (msg.toLowerCase().equals("success")) {
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} else
			return new ResponseEntity<String>("Failed", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/softDeleteAcc/{accountId}")
	public ResponseEntity<String> softDeleteCaseWorkerAcc(@PathVariable Integer accountId) {
		String msg = service.softDeleteCaseWorkerAcc(accountId);
		if (msg.toLowerCase().equals("success")) {
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} else
			return new ResponseEntity<String>("Failed", HttpStatus.BAD_REQUEST);
	}

}
