package com.nikhil.service;

import java.util.List;

import com.nikhil.Entity.StateInsurancePlans;

public interface PlansManagementInterface {
	
    public List<StateInsurancePlans> viewPlans();
	public String createPlan(StateInsurancePlans planForm);
	public StateInsurancePlans editPlan(Integer planId);
	public String planHardDelete(Integer planId);
	public String planSoftDelete(Integer planId);

}
