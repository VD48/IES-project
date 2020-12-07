package com.ies.dc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ies.admin.domain.PlanRegister;

import com.ies.admin.service.PlanService;
import com.ies.applicationregister.domain.ApplicantRegistration;
import com.ies.dc.domain.Caseform;
import com.ies.dc.domain.ChildDetailsDto;
import com.ies.dc.domain.EducationDetailsDto;
import com.ies.dc.domain.IncomeDetailsDto;
import com.ies.dc.domain.SelectPlan;

import com.ies.dc.service.CaseService;

@Controller
public class CreateCaseFormController {
	@Autowired
	private CaseService caseservice;
	@Autowired
	private PlanService planService;

	@GetMapping(value = "/emptyForm")
	public String loadEmptyCaseForm() {
		return "caseForm";
	}

	@GetMapping(value = "/getApplicant")
	public String getApplicantData(HttpServletRequest request, Model model) {
		String id = request.getParameter("applicationNo");
		ApplicantRegistration applicant = caseservice.getApplicant(id);
		if (applicant != null) {
			Caseform caseform = new Caseform();
			BeanUtils.copyProperties(applicant, caseform);
			model.addAttribute("caseform", caseform);
			return "createCase";
		} else {

			return "caseForm";
		}

	}

	@PostMapping(value = "/createCase")
	public String createCase(@ModelAttribute("caseform") Caseform caseform, Model model) {
		System.out.println(caseform);
		Caseform saveEntity = caseservice.saveCase(caseform);
		if (saveEntity != null) {
			List<PlanRegister> planList = planService.getAllPlan();
			List<String> planlist = new ArrayList<>();
			planList.forEach(planName -> {
				String a = planName.getPlanName();
				planlist.add(a);
			});
			SelectPlan selectPlan = new SelectPlan();
			selectPlan.setCaseNo(caseform.getCaseNo());

			model.addAttribute("planList", planlist);
			model.addAttribute("selectPlan", selectPlan);
			model.addAttribute("succMsg", "case is created and case no is" + saveEntity.getCaseNo());
			return "selectPlan";
		} else {
			model.addAttribute("failMsg", "unable to create case");
			return "createCase";
		}

	}

	@PostMapping(value = "/selectPlan")
	public String saveSelectPlan(@ModelAttribute("selectPlan") SelectPlan selectPlan, Model model) {

		SelectPlan selectPlanData = caseservice.saveSelectPlan(selectPlan);
		if (selectPlanData != null) {
			if (selectPlanData.getPlanName().equals("SNAP")) {
				IncomeDetailsDto incomeDetails = new IncomeDetailsDto();
				incomeDetails.setCaseNo(selectPlan.getCaseNo());
				incomeDetails.setFirstName(selectPlanData.getFirstName()+" "+selectPlanData.getLastName());
				model.addAttribute("incomeDetails", incomeDetails);
				return "incomeDetails";
			} else if (selectPlanData.getPlanName().equals("KTWORKS")) {
				EducationDetailsDto educationDetails = new EducationDetailsDto();
				educationDetails.setCaseNo(selectPlanData.getCaseNo());
				educationDetails.setFirstName(selectPlanData.getFirstName()+" "+selectPlanData.getLastName());
				model.addAttribute("educationDetails", educationDetails);

				return "educationDetails";
			}
			if (selectPlanData.getPlanName().equals("CCAP")) {
				ChildDetailsDto childDetails = new ChildDetailsDto();
				childDetails.setCaseNo(selectPlanData.getCaseNo());
				childDetails.setFirstName(selectPlanData.getFirstName() + " " + selectPlanData.getLastName());
				model.addAttribute("childDetails", childDetails);
				return "childDetails";
			} else {
				return "redirect:/emptyForm";
			}

		} else {
			return null;
		}

	}

	
	@PostMapping(value = "/income")
	public String addIncomeDetails(Model model, @ModelAttribute("incomeDetails") IncomeDetailsDto incomeDetails) {
		Boolean isSaved = caseservice.saveIncomeDetails(incomeDetails);
		if (isSaved) {
			model.addAttribute("succMsg", "Income Details is Saved");

		} else {
			model.addAttribute("fail", "Unable to Save Data");
		}
		return "incomeDetails";
	}
	
	
	@PostMapping(value = "/educationPlan")
	public String addEducationDetails(Model model,@ModelAttribute("educationDetails")EducationDetailsDto educationDetails) {
		
		Boolean isSaved = caseservice.SaveEducationDetails(educationDetails);
		if(isSaved) {
			model.addAttribute("succMsg", "Education Details is saved");
		}else {
			model.addAttribute("failMsg", "Unable to Save the Details");
		}
		
		return "educationDetails";
		
	}
	@GetMapping(value = "/viewChilds")
	public String getAllChild(Model model) {
		List<ChildDetailsDto> allChilds = caseservice.getAllChilds();
		model.addAttribute("allChilds", allChilds);
		return "viewChilds";
	}
	@PostMapping(value = "/childPlan")
	public String addChild(@ModelAttribute("childDetails")ChildDetailsDto childDetails,Model model) {
		Boolean isSaved = caseservice.saveChildDetails(childDetails);
		if(isSaved) {
				return "childDetails";
			 
		}else {
			return "childDetails";
		}
	}
	
	@GetMapping(value = "/editChild")
	public String editChild(@RequestParam("id")Integer id,Model model) {
		ChildDetailsDto childDetails = caseservice.editChildDetails(id);
		model.addAttribute("childDetails", childDetails);
		return "redirect:/viewChilds";
		
	}
	@GetMapping("/deleteChild")
	public String deleteChild(@RequestParam("id")Integer id,Model model) {
		 caseservice.deleteChild(id);
		 ChildDetailsDto childDetails=new ChildDetailsDto();
		 model.addAttribute("childDetails", childDetails);
		 return "redirect:/viewChilds";
	}


	
}
