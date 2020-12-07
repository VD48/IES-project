package com.ies.admin.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ies.admin.domain.AdminAccount;
import com.ies.admin.service.AdminAccountService;
import com.ies.constants.AppConstants;

@Controller
public class AdminRegistrationcontroller {
	@Autowired
	private AdminAccountService adminService;

	@GetMapping(value = "/")
	public String loadHomePage() {
		return AppConstants.HEADER_VIEW_NAME;
	}

	@GetMapping("/load")
	public String loadForm(Model model) {
		AdminAccount account = new AdminAccount();
		model.addAttribute(AppConstants.ACCOUNT, account);
		return AppConstants.REGISTER_VIEW_NAME;

	}

	@PostMapping(value = "/register")
	public String handleRegisterButton(@ModelAttribute("account") AdminAccount account, Model model,
			RedirectAttributes redirectAttributes) {
		boolean isSaved = adminService.saveAdminAccount(account);

		if (isSaved) {
			model.addAttribute(AppConstants.SUCC_MSG, "Registration Succussful");
		} else {
			model.addAttribute(AppConstants.FAIL_MSG, "Registration Failed");
		}

		redirectAttributes.addFlashAttribute(AppConstants.SUCC_MSG, "Registration Succussful");
		return "redirect:/"+AppConstants.VIEW_LOAD_VIEW_NAME;
	}

	@GetMapping(value = "/uniqueMailCheck")
	public @ResponseBody String isEmailUnique(@RequestParam("email") String email) {

		return adminService.isUniqueEmail(email) ? "UNIQUE" : "DUPLICATE";
	}

	@GetMapping(value = "/viewAccount")
	public String getAllAccountsByRole(Model model, @RequestParam("role") String role) {

		List<AdminAccount> adminRoleList = adminService.getAllAccountsByRole(role);
		model.addAttribute(AppConstants.ADMINROLELIST, adminRoleList);
		return AppConstants.VIEW_ACCOUNTS_VIEW_NAME;
	}

	@GetMapping(value = "/edit")
	public String editAccount(@RequestParam("id") int id, Model model) {
		AdminAccount account = adminService.editAdminAccount(id);
		if(account!=null) {
			model.addAttribute(AppConstants.ACCOUNT, account);
		}
		
		return AppConstants.UPDATE_ACCOUNT_VIEW_NAME;
	}
	@PostMapping(value = "/update")
	public String updateAdminAccount(@ModelAttribute("account")AdminAccount account,Model model,RedirectAttributes redirectAttributes) {
		boolean isUpdate = adminService.updateAdminAccount(account);
		if(isUpdate) {
			redirectAttributes.addFlashAttribute("succMsg", "Account Updated Succusfully");
			return "redirect:/"+AppConstants.VIEW_LOAD_VIEW_NAME;
		}else {
		throw new RuntimeException();
		}
	
	}
	@GetMapping(value = "/delete")
	public String deleteAdminAccount(@RequestParam("id") int id) {
		boolean isDelete = adminService.deleteAdminAccount(id);
		if(isDelete) {
			return AppConstants.VIEW_ACCOUNTS_VIEW_NAME;
		}
		else{
			throw new RuntimeException();
		}
	}

}
