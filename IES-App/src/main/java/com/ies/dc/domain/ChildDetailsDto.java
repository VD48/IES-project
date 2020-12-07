package com.ies.dc.domain;

import java.util.Date;

import lombok.Data;
@Data
public class ChildDetailsDto {
	
	private Integer childId;
	private String caseNo;
	private String firstName;
	private String childName;
	private String childGender;
	private Date childDob;
	private String childSSN;
	

}
