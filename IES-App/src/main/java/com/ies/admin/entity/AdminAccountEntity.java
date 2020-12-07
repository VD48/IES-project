package com.ies.admin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;
@Entity
@Data
@Table(name = "ADMIN_TABLE")

public class AdminAccountEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SR_NO")
	protected int srNo;
	@Column(name = "FIRST_NAME")
	protected String firstName;
	@Column(name = "LAST_NAME")
	protected String lastName;
	@Column(name = "EMAIL_ADD")
	protected String emailAdd;
	@Column(name = "PAZZWORD")
	protected String pazzword;
	@Column(name = "DOB")
	protected Date dob;
	@Column(name = "GENDER")
	protected String gender;
	@Column(name = "SSN_NO")
	protected String ssnNo;
	@Column(name = "PHONE_NO")
	protected String phoneNo;
	@Column(name = "ROLE")
	protected String role;
	@Column(name = "STATUS")
	protected Boolean status;
	

}
