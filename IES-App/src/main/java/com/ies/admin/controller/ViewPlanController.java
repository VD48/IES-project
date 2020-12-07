package com.ies.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ies.admin.domain.PlanRegister;
import com.ies.admin.service.PlanService;
import com.ies.constants.AppConstants;

@Controller
public class ViewPlanController {
	
	@Autowired
    private PlanService planService;
	
	@GetMapping(value = "/viewPlan")
	public String viewAllPlan(Model model) {
		List<PlanRegister> planList = planService.getAllPlan();
		model.addAttribute(AppConstants.PLANLIST,planList);
		return AppConstants.VIEW_PLAN_VIEW_NAME;
	}
	@GetMapping(value = "/editPlan")
	public String editPlan(@RequestParam("planNo")Integer planNo,Model model) {
		PlanRegister planRegister = planService.editPlan(planNo);
		if(planRegister!=null) {
			model.addAttribute(AppConstants.PLAN_REGISTER, planRegister);
			return AppConstants.UPDATE_PLAN_VIEW_NAME;
		}else {
		throw new RuntimeException();
		}
	}
	
	@PostMapping(value = "/updatePlan")
	public String updatePlan(@ModelAttribute("planRegister") PlanRegister planRegister,RedirectAttributes attributes) {
		Boolean isUpdate = planService.updatePlan(planRegister);
		if(isUpdate) {
			return "redirect:/"+AppConstants.VIEW_PLAN_VIEW_NAME;
		}else {
		
		throw new RuntimeException();
		}
	}
	@GetMapping(value = "/deletePlan")
	public String deletePlan(@RequestParam("planNo")Integer planNo) {
		Boolean isDelete = planService.deletePlaN(planNo);
		if(isDelete) {
			return "redirect:/"+AppConstants.VIEW_PLAN_VIEW_NAME;
		}else {
		throw new RuntimeException();
		}
	}
	
}
