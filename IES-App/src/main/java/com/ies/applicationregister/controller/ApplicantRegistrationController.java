package com.ies.applicationregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ies.applicationregister.domain.ApplicantRegistration;
import com.ies.applicationregister.service.ApplicantService;
import com.ies.constants.AppConstants;

@Controller
public class ApplicantRegistrationController {
	@Autowired
	private ApplicantService applicantService;
	
	@GetMapping(value = "/applicantForm")
	public String loadApplicantRegistrationForm(Model model) {
		ApplicantRegistration applicantRegistration=new ApplicantRegistration();
		model.addAttribute(AppConstants.APPLICATION_REGISTRATION, applicantRegistration);
		return AppConstants.APPLICATION_REGISTRATION_VIEW_NAME;
	}
	@PostMapping(value = "/applicantRegister")
	public String addAppliacant(RedirectAttributes attributes,@ModelAttribute("applicantRegistration" )ApplicantRegistration applicantRegistration) {
		
		
		Boolean isSaved = applicantService.saveApplicant(applicantRegistration);
		if(isSaved) {
			attributes.addFlashAttribute(AppConstants.SUCC_MSG, "Applicant is saved");
		}else {
			attributes.addFlashAttribute(AppConstants.FAIL_MSG, "unable to Saved applicant");
		}
		
		return "redirect:/applicantForm";
	}
	
	

}
