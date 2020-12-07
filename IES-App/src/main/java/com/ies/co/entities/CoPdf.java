package com.ies.co.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "co_pdfs")
@Data
public class CoPdf {
	@Id
	@Column(name = "co_pdf_id")
	private Integer CoPdfId;
	@Column(name = "plan_status")
	private String planStatus;
	@Column(name = "case_number")
	private String caseNumber;
	@Column(name = "pdf_document")
	private Byte[] pdfDocument;
	@Column(name = "plan_name")
	private String PlanName;

}
