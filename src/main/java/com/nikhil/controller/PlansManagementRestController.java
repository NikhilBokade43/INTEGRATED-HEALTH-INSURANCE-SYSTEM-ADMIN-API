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

import com.nikhil.Entity.StateInsurancePlans;
import com.nikhil.service.PlansManagementInterface;

@RestController
public class PlansManagementRestController {

	@Autowired
	private PlansManagementInterface service;

	@GetMapping("/viewPlans")
	public ResponseEntity<List<StateInsurancePlans>> viewPlans() {
		List<StateInsurancePlans> plansList = service.viewPlans();
		return new ResponseEntity<>(plansList, HttpStatus.OK);
	}

	@PostMapping("/createPlan")
	public ResponseEntity<String> createPlan(@RequestBody StateInsurancePlans planForm) {
		String msg = service.createPlan(planForm);
		if (msg.toLowerCase().equals("success")) {
			return new ResponseEntity<>(msg, HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Fialed", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("editplan/{planId}")
	public ResponseEntity<StateInsurancePlans> editPlan(@PathVariable Integer planId) {
		StateInsurancePlans entity = service.editPlan(planId);
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}

	@GetMapping("hardDelete/{planId}")
	public ResponseEntity<String> planHardDelete(@PathVariable Integer planId) {
		String status = service.planHardDelete(planId);
		if (status.toLowerCase().equals("success")) {
			return new ResponseEntity<>(status, HttpStatus.OK);
		}
		return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("softDelete/{planId}")
	public ResponseEntity<String> planSoftDelete(@PathVariable Integer planId) {
		String status = service.planSoftDelete(planId);
		if (status.toLowerCase().equals("success")) {
			return new ResponseEntity<>(status, HttpStatus.OK);
		}
		return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
	}

}
