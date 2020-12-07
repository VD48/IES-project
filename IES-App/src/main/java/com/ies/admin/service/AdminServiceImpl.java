package com.ies.admin.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ies.admin.domain.AdminAccount;
import com.ies.admin.entity.AdminAccountEntity;
import com.ies.admin.repository.AdminRepository;
import com.ies.constants.AppConstants;
import com.ies.util.EmailUtils;

@Service
public class AdminServiceImpl implements AdminAccountService{
	
	@Autowired
    private AdminRepository adminRepo;
	@Autowired
	private EmailUtils emailUtils;
	@Override
	public boolean saveAdminAccount(AdminAccount account) {
		
		AdminAccountEntity entity=new AdminAccountEntity();
		BeanUtils.copyProperties(account, entity);
		AdminAccountEntity isSave = adminRepo.save(entity);
	    if(isSave !=null) {
	    	String email=isSave.getEmailAdd();
	    	String subject="Registraation Succuss Mail";
	    	String body=getEmailSuccussBody(account);
	    	sendAccountCreationSuccusMail(email, body, subject);
	    	return true;
	    }
		return false;
	}

	@Override
	public AdminAccount editAdminAccount(int id) {
		AdminAccount account=new AdminAccount();
		Optional<AdminAccountEntity> findById = adminRepo.findById(id);
		AdminAccountEntity entity = findById.get();
		
		if(entity !=null) {
			BeanUtils.copyProperties(entity, account);
			return account;
		}else {
		
	    throw new RuntimeException();
		}
	}

	@Override
	@Transactional
	public boolean deleteAdminAccount(int id) {
		
		adminRepo.softDelete(id);;
		return true;
	}

	@Override
	public List<AdminAccount> getAllAccounts() {
		List<AdminAccountEntity> conEntities = adminRepo.findAll();
		List<AdminAccount> accounts=new ArrayList<>();
		conEntities.forEach(entity->{
			AdminAccount account=new AdminAccount();
			BeanUtils.copyProperties(entity, account);
			accounts.add(account);
		});
		return accounts;
	}

	@Override
	public boolean isUniqueEmail(String emailAdd) {
		AdminAccountEntity entity = adminRepo.findByEmailAdd(emailAdd);
		return entity != null ? false : true; 
	}

	@Override
	public String getEmailSuccussBody(AdminAccount account) {
		String fileName=AppConstants.MAIL_FILENAME;
		List<String> replacedLines = null;
		String mailBody = null;
		Stream<String> lines = null;
		Path path=Paths.get(fileName, AppConstants.EMPTY_STRING);
		try {
			lines = Files.lines(path);
			replacedLines=lines.map(line -> line.replace(AppConstants.FIRST_NAME, account.getFirstName())
					              .replace(AppConstants.LAST_NAME, account.getLastName())
					              .replace(AppConstants.REPLACED_EMAIL, account.getEmailAdd())
					              .replace(AppConstants.PZWD, account.getPazzword()))
			                       .collect(Collectors.toList());
			                      
			mailBody = String.join(AppConstants.EMPTY_STRING, replacedLines);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return mailBody;
	}

	@Override
	public boolean sendAccountCreationSuccusMail(String email, String body, String subject) {
		boolean isSendEmail = emailUtils.sendEmail(email, subject, body);
		if(isSendEmail) {
			return true;
		}
		return false;
	}

	

	@Override
	public List<AdminAccount> getAllAccountsByRole(String role) {
		List<AdminAccountEntity> conEntities = adminRepo.findByRole(role);
		List<AdminAccount> accounts=new ArrayList<>();
		conEntities.forEach(entity->{
			AdminAccount account=new AdminAccount();
			BeanUtils.copyProperties(entity, account);
			accounts.add(account);
		});
		return accounts;
	}

	@Override
	public boolean updateAdminAccount(AdminAccount account) {
		AdminAccountEntity entity=new AdminAccountEntity();
		BeanUtils.copyProperties(account, entity);
		AdminAccountEntity updateEntity = adminRepo.save(entity);
		if(updateEntity!=null) {
			return true;
		}else {
		throw new RuntimeException();
		}
	}
	

}
