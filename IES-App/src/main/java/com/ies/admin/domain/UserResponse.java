package com.ies.admin.domain;

import java.util.Date;

import lombok.Data;
@Data
public class UserResponse {

	private String firstname;
	private String lastName;
	private String ssnNo;
	private String stateName;
	private String gender;
	private Date dob;
	
}
