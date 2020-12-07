package com.ies.co.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "co_triggers")
public class CoTriggers {
    @Id
    @Column(name = "trg_id")
	private Integer TrgId;
    @Column(name = "case_num")
	private Integer caseNumber;
    @Column(name = "create_dt")
	private Date createDate;
    @Column(name = "trg_status")
	private String trgStatus;
    @Column(name = "update_dt")
	private Date updateDate;
}
