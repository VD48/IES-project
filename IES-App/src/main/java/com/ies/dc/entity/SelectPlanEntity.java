package com.ies.dc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "DC_PLANS")
@Entity
public class SelectPlanEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "CASE_NO")
	private String caseNo;
    @Column(name = "FIRST_NAME")
	private String firstName;
    @Column(name = "LAST_NAME")
	private String lastName;
    @Column(name = "PLAN_NAME")
	private String planName;
}
