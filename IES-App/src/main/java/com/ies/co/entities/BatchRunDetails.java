package com.ies.co.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "batch_run_dtls")
@Data
public class BatchRunDetails {
	
	@Column(name = "batch_run_seq")
	@Id
  private Integer batchRunSeq;
	@Column(name = "batch_name")
  private String batchName;
	@Column(name = "batch_run_status")
  private String batchRunStatus;
	@Column(name = "end_date")
  private Date endDate;
	@Column(name = "instance_num")
  private Integer instanceNumber;
	@Column(name = "start_name")
  private Date startDate;
}
