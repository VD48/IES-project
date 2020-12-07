package com.ies.applicationregister.domain;

import java.util.Date;

import lombok.Data;
@Data
public class ApplicantRegistration {
  
	private String applicantRegNo;
	private String firstName;
	private String lastName;
	private String emailAdd;
	private String gender;
	private String ssnNo;
	private Date dob;
	private String phoneNo;
	private Boolean status;
}
