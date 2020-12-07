package com.ies.admin.service;

import java.util.List;

import com.ies.admin.domain.PlanRegister;

public interface PlanService {

	public Boolean savePlan(PlanRegister planRegister);
	public List<PlanRegister> getAllPlan();
	public PlanRegister editPlan(int planNo);
	public Boolean updatePlan(PlanRegister planRegister);
	public Boolean deletePlaN(Integer id);
	
}
