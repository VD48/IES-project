package com.ies.admin.domain;

import java.util.Date;

import lombok.Data;
@Data
public class PlanRegister {
    protected Integer planNo;
	protected String planName;
	protected String planDescription;
	protected Date planStartDate;
	protected Date planEndDate;
	protected Boolean status;
	
}
