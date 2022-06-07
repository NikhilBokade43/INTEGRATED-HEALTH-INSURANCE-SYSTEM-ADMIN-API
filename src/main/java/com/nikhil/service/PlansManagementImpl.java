package com.nikhil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikhil.Entity.StateInsurancePlans;
import com.nikhil.Repository.StateInsurancePlansRepo;

@Service
public class PlansManagementImpl implements PlansManagementInterface {
	@Autowired
	private StateInsurancePlansRepo plansRepo;

	@Override
	public List<StateInsurancePlans> viewPlans() {
		return plansRepo.findAll();
		
	}

	@Override
	public String createPlan(StateInsurancePlans planForm) {
		planForm.setActiveSW("Y");
		StateInsurancePlans planEntity = plansRepo.save(planForm);
		if(planEntity.getPlanName()!= null && planEntity.getPlanName()!= "") {
			return "SUCCESS";
		}
		return "FAILED TO SAVE DATA !!";
	}

	@Override
	public StateInsurancePlans editPlan(Integer planId) {
		Optional<StateInsurancePlans> optional = plansRepo.findById(planId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public String planHardDelete(Integer planId) {
		plansRepo.deleteById(planId);
		return "SUCCESS";
	}

	@Override
	public String planSoftDelete(Integer planId) {
		Optional<StateInsurancePlans> optional = plansRepo.findById(planId);
		if(optional.isPresent()) {
			StateInsurancePlans entity = optional.get();
			entity.setActiveSW("N");
			return "SUCCESS";
		}
		return "FAILED";
	}
}
