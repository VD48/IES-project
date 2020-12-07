package com.ies.dc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "DC_IMCOME")
public class IncomeDetailsEntity implements Serializable {
    
	private static final long serialVersionUID = 1L;
	@Id
     @Column(name = "CASE_NO")
	private String caseNo;
     @Column(name = "FIRST_NAME")
	private String firstName;
     @Column(name = "LAST_NAME")
	private String lastName;
     @Column(name = "WORKING_EMP")
	private String workingEmployee;
     @Column(name = "OTHER_INCOME")
	private String otherIncome;
}

