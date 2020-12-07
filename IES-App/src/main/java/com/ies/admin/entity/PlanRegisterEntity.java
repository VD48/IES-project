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
@Table(name = "PLAN_DTLS")
@Data
public class PlanRegisterEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PLAN_NO")
	private Integer planNo;
	@Column(name ="PLAN_NAME")
	private String planName;
	@Column(name = "PLAN_DSCRPTN")
	private String planDescription;
	@Column(name = "PLAN_START_DT")
	private Date planStartDate;
	@Column(name = "PLAN_END_DT")
	private Date planEndDate;
	@Column(name = "isActivate")
	private Boolean status;

}
