package com.ies.dc.service;




import java.util.List;

import com.ies.applicationregister.domain.ApplicantRegistration;
import com.ies.dc.domain.Caseform;
import com.ies.dc.domain.ChildDetailsDto;
import com.ies.dc.domain.EducationDetailsDto;
import com.ies.dc.domain.IncomeDetailsDto;
import com.ies.dc.domain.SelectPlan;

public interface CaseService {

	public ApplicantRegistration getApplicant(String id);
	public Caseform saveCase(Caseform caseform);
	public SelectPlan saveSelectPlan(SelectPlan selectPlan);
	public Boolean saveIncomeDetails(IncomeDetailsDto incomeDetailsDto);
	public Boolean SaveEducationDetails(EducationDetailsDto educationDetailsDto);
	public Boolean saveChildDetails(ChildDetailsDto childDetailsDto);
	public ChildDetailsDto editChildDetails(Integer id);
	public Boolean UpdateChildDetails(ChildDetailsDto childDetailsDto);
	public List<ChildDetailsDto> getAllChilds();
	public Boolean deleteChild(Integer id);
	
}
