package com.ies.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ies.admin.domain.PlanRegister;
import com.ies.admin.service.PlanService;
import com.ies.constants.AppConstants;

@Controller
public class PlanRegistrationController {
	@Autowired
	private PlanService planService;

	@GetMapping(value = "/loadPlanForm")
	public String registerPlan(Model model) {
		PlanRegister planRegister = new PlanRegister();
		model.addAttribute(AppConstants.PLAN_REGISTER, planRegister);
		return AppConstants.PLANREGISTER_VIEW_NAME;
	}
	
	@PostMapping(value = "/createPlan")
	public String registerPlan(Model model,@ModelAttribute("planRegister")PlanRegister planRegister,RedirectAttributes redirectAttributes) {
		System.out.println(planRegister.getPlanEndDate()+"77777777777");
		Boolean isSaved = planService.savePlan(planRegister);
		if(isSaved) {
			redirectAttributes.addFlashAttribute(AppConstants.SUCC_MSG, "Plan is Created");
		}else {
			redirectAttributes.addFlashAttribute(AppConstants.FAIL_MSG,"Unable To CreatePlan");
		}
		
		return "redirect:/"+AppConstants.LOAD_PLAN_FROM_VIEW_NAME;
	}
}
