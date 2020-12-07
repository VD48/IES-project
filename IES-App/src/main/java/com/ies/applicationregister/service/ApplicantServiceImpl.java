package com.ies.applicationregister.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.ies.admin.domain.UserResponse;
import com.ies.applicationregister.domain.ApplicantRegistration;
import com.ies.applicationregister.entity.ApplicantRegisterEntity;
import com.ies.applicationregister.repository.ApplicantRepository;
import com.ies.exception.ApplicantEditException;
import com.ies.exception.ApplicantNotSavedException;


@Service
public class ApplicantServiceImpl implements ApplicantService {
	@Autowired
	private ApplicantRepository applicantRepo;

	@Override
	public Boolean saveApplicant(ApplicantRegistration applicantRegistration) {
		Boolean isValid = SsaCLient(applicantRegistration.getSsnNo());
		if (isValid) {
			ApplicantRegisterEntity entity = new ApplicantRegisterEntity();
			BeanUtils.copyProperties(applicantRegistration, entity);
			ApplicantRegisterEntity applicantEntity = applicantRepo.save(entity);
			    if(applicantEntity!=null) {
			    	return true;
			    }else {
					throw new ApplicantNotSavedException(); 
				}

		} else {
			return false;
		}
		

	}

	@Override
	public ApplicantRegistration editApplicant(String applicantNo) {
		Optional<ApplicantRegisterEntity> optionEntity = applicantRepo.findById(applicantNo);
		if (optionEntity.isPresent()) {
			ApplicantRegisterEntity applicantRegisterEntity = optionEntity.get();
			ApplicantRegistration applicantRegistration = new ApplicantRegistration();
			BeanUtils.copyProperties(applicantRegisterEntity, applicantRegistration);
			return applicantRegistration;
		}
		throw new ApplicantEditException();

	}

	@Override
	public Boolean updateApplicant(ApplicantRegistration applicantRegistration) {
		ApplicantRegisterEntity entity = new ApplicantRegisterEntity();
		BeanUtils.copyProperties(applicantRegistration, entity);
		ApplicantRegisterEntity applicantEntity = applicantRepo.save(entity);
		if (applicantEntity != null) {
			return true;
		}else {
		throw new ApplicantNotSavedException();
		}
	}

	@Override
	@Transactional
	public Boolean deleteApplicant(String applicantNo) {
		if (applicantNo != null) {
			applicantRepo.softDeletePlan(applicantNo);;
			return true;
		}else {
			return false;	
		}

		
	}

	@Override
	public List<ApplicantRegistration> getAllApplicants() {
		List<ApplicantRegisterEntity> listEntity = applicantRepo.findAll();
		
		List<ApplicantRegistration> applicants = new ArrayList<>();
		
		listEntity.forEach(entity->{
			ApplicantRegistration applicantRegistration=new ApplicantRegistration();
			BeanUtils.copyProperties(entity, applicantRegistration);
			applicants.add(applicantRegistration);
			
		});

		return applicants;
	}

	@Override
	public Boolean SsaCLient(String ssaNo) {
		String SSA_END_POINT_URL = "http://localhost:7070/verify/" + ssaNo;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserResponse> ssaResponse = restTemplate.getForEntity(SSA_END_POINT_URL, UserResponse.class);
		int statusCode = ssaResponse.getStatusCodeValue();
		UserResponse body = ssaResponse.getBody();
		if (statusCode == 200) {
			if (body.getStateName().equals("kentucky")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

}
