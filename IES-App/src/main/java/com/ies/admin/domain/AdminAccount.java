package com.ies.admin.domain;

import java.util.Date;

import lombok.Data;
@Data
public class AdminAccount {
    protected int srNo;
	protected String firstName;
	protected String lastName;
	protected String emailAdd;
	protected String pazzword;
	protected Date dob;
	protected String gender;
	protected String ssnNo;
	protected String phoneNo;
	protected String role;
	protected Boolean status;
	
}
