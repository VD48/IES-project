package com.ies.applicationregister.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Table(name = "APPLICANT_REGTR")
@Entity
public class ApplicantRegisterEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "APPNO_GEN",strategy = "com.ies.applicationregister.genrator.ApplicantGenrator")
	@GeneratedValue(generator = "APPNO_GEN")
	@Column(name = "APPLICANT_REG_NO")
	private String applicantRegNo;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL_ADD")
	private String emailAdd;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "SSN_NO")
	private String ssnNo;
	@Column(name = "DOB")
	private Date dob;
	@Column(name = "PHONE_NO")
	private String phoneNo;
	@Column(name = "STATUS")
	private Boolean status;

}
