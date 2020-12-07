package com.ies.applicationregister.service;

import java.util.List;

import com.ies.applicationregister.domain.ApplicantRegistration;

public interface ApplicantService {

	public Boolean saveApplicant(ApplicantRegistration applicantRegistration);
	public ApplicantRegistration editApplicant(String applicantNo);
	public Boolean updateApplicant(ApplicantRegistration applicantRegistration);
	public Boolean deleteApplicant(String applicantNo);
	public List<ApplicantRegistration> getAllApplicants();
	public Boolean SsaCLient(String ssaNo);
}
