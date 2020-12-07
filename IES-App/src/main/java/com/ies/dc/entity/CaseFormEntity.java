package com.ies.dc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



import lombok.Data;
@Entity
@Data
@Table(name = "DC_CASES")
public class CaseFormEntity  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "CASE_NO_GEN")
	@GenericGenerator(name = "CASE_NO_GEN",strategy = "com.ies.dc.genrator.CaseNoGenrator")
	private String caseNo;
	@Column(name = "APPLICANT_ID")
	private String applicantRegNo;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "SSN_NO")
	private String ssnNo;
	@Column(name = "DOB")
	private Date dob;
	@Column(name = "PHONE_NO")
	private String phoneNo;
	@Column(name = "EMAIL_ADD")
	private String emailAdd;

}
