package com.ies.dc.domain;

import java.util.Date;

import lombok.Data;
@Data
public class Caseform {
	private String caseNo;
	private String applicantRegNo;
	private String firstName;
	private String lastName;
	private String gender;
	private String ssnNo;
	private Date dob;
	private String phoneNo;
	private String emailAdd;
}
