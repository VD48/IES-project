package com.ies.admin.service;

import java.util.List;

import com.ies.admin.domain.AdminAccount;

public interface AdminAccountService {
	
	public boolean saveAdminAccount(AdminAccount account);
	public AdminAccount editAdminAccount(int id);
	public boolean updateAdminAccount(AdminAccount account);
	public boolean deleteAdminAccount(int id);
	public List<AdminAccount> getAllAccounts();
	public boolean isUniqueEmail(String emailAdd);
	public String getEmailSuccussBody(AdminAccount account);
	public boolean sendAccountCreationSuccusMail(String email,String body,String subject);
	public List<AdminAccount> getAllAccountsByRole(String role);

}
