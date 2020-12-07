package com.ies.applicationregister.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ies.applicationregister.domain.ApplicantRegistration;
import com.ies.applicationregister.service.ApplicantService;
import com.ies.constants.AppConstants;

@Controller
public class ViewApplicantController {
	@Autowired
	private ApplicantService applicantService;

	@GetMapping(value = "/viewApplicant")
	public String viewAllApllicant(Model model) {
		List<ApplicantRegistration> allApplicants = applicantService.getAllApplicants();

		model.addAttribute(AppConstants.ALL_APPLICANT, allApplicants);

		return AppConstants.VIEW_APPLICANT_VIEW_NAME;
	}

	@GetMapping("/editApplicant")
	public String editApplicant(@RequestParam("regNo") String applicantNo, Model model) {
		ApplicantRegistration applicantRegistration = applicantService.editApplicant(applicantNo);
		model.addAttribute(AppConstants.APPLICATION_REGISTRATION, applicantRegistration);
		return AppConstants.UPDATE_APPLICANT_VIEW_NAME;
	}

	@PostMapping(value = "/updateApplicant")
	public String updateApplicant(@ModelAttribute("applicantRegistration") ApplicantRegistration applicantRegistration,
			RedirectAttributes attributes) {
		Boolean isUpdate = applicantService.updateApplicant(applicantRegistration);
		if (isUpdate) {
			attributes.addFlashAttribute(AppConstants.SUCC_MSG, "Applicant is Updated Succusfully");
		} else {
			attributes.addFlashAttribute(AppConstants.FAIL_MSG, "Unable to Update Applicant");
		}
		return "redirect:/applicantForm";
	}

	@GetMapping(value = "/deleteApplicant")
	public String deleteApplicant(@RequestParam("regNo") String applicantNo) {
		if (applicantNo != null) {
			 applicantService.deleteApplicant(applicantNo);
		}

		return "redirect:/viewApplicant";
	}

}
