package com.ies.dc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "DC_EDUCATION")
public class EducationDetailsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CASE_NO")
	private String caseNo;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "QUALIFICATION")
	private String qualification;
	@Column(name = "COMPLETED_YEAR")
	private String completedYear;
	@Column(name = "GRADE")
	private String grade;
}
