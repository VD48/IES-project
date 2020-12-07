package com.ies.dc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


import lombok.Data;
@Data
@Entity
@Table(name = "DC_CHILD")
public class ChildDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CHILD_ID")
    private Integer childId;
    @Column(name = "CASE_NO")
	private String caseNo;
    @Column(name = "FIRST_NAME")
	private String firstName;
    @Column(name = "CHILD_NAME")
	private String childName;
    @Column(name = "CHILD_GENDER")
	private String childGender;
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Column(name = "CHILD_DOB")
	private Date childDob;
    @Column(name = "CHILD_SSN")
	private String childSSN;
}
