package com.ies.dc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ies.applicationregister.domain.ApplicantRegistration;
import com.ies.applicationregister.entity.ApplicantRegisterEntity;
import com.ies.applicationregister.repository.ApplicantRepository;
import com.ies.dc.domain.Caseform;
import com.ies.dc.domain.ChildDetailsDto;
import com.ies.dc.domain.EducationDetailsDto;
import com.ies.dc.domain.IncomeDetailsDto;
import com.ies.dc.domain.SelectPlan;
import com.ies.dc.entity.CaseFormEntity;
import com.ies.dc.entity.ChildDetailsEntity;
import com.ies.dc.entity.EducationDetailsEntity;
import com.ies.dc.entity.IncomeDetailsEntity;
import com.ies.dc.entity.SelectPlanEntity;
import com.ies.dc.repository.CaseRepository;
import com.ies.dc.repository.ChildDetailsRepository;
import com.ies.dc.repository.EducationDetailsRepository;
import com.ies.dc.repository.IncomeDetailsRepository;
import com.ies.dc.repository.SelectPlanRepository;

@Service
public class CaseServiceImpl implements CaseService {
	@Autowired
	private ApplicantRepository applicantRepo;

	@Autowired
	private CaseRepository caseRepo;

	@Autowired
	private SelectPlanRepository selectPlanRepo;
	@Autowired
	private IncomeDetailsRepository incomeDetailsRepo;

	@Autowired
	private EducationDetailsRepository eduDetailsRepo;
	
	@Autowired
	private ChildDetailsRepository childRepo;

	private ChildDetailsEntity childDetailsEntity;

	@Override
	public ApplicantRegistration getApplicant(String id) {
		Optional<ApplicantRegisterEntity> entity = applicantRepo.findById(id);
		if (entity.isPresent()) {
			ApplicantRegistration app = new ApplicantRegistration();
			ApplicantRegisterEntity applicantRegisterEntity = entity.get();
			BeanUtils.copyProperties(applicantRegisterEntity, app);
			return app;
		}
		return null;
	}

	@Override
	public Caseform saveCase(Caseform caseform) {
		CaseFormEntity entity = new CaseFormEntity();
		BeanUtils.copyProperties(caseform, entity);
		CaseFormEntity save = caseRepo.save(entity);
		BeanUtils.copyProperties(save, caseform);

		return caseform;
	}

	@Override
	public SelectPlan saveSelectPlan(SelectPlan selectPlan) {
		SelectPlanEntity entity = new SelectPlanEntity();
		BeanUtils.copyProperties(selectPlan, entity);
		SelectPlanEntity savedEntity = selectPlanRepo.save(entity);
		BeanUtils.copyProperties(savedEntity, selectPlan);
		if (selectPlan != null) {
			return selectPlan;
		} else {
			return null;
		}

	}

	@Override
	public Boolean saveIncomeDetails(IncomeDetailsDto incomeDetailsDto) {
		IncomeDetailsEntity entity = new IncomeDetailsEntity();
		BeanUtils.copyProperties(incomeDetailsDto, entity);
		IncomeDetailsEntity incomeEntity = incomeDetailsRepo.save(entity);
		if (incomeEntity != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean SaveEducationDetails(EducationDetailsDto educationDetailsDto) {
		EducationDetailsEntity entity=new EducationDetailsEntity();
		BeanUtils.copyProperties(educationDetailsDto, entity);
		EducationDetailsEntity eduEntity = eduDetailsRepo.save(entity);
		if(eduEntity!=null) {
			return true;
		}else {
			return false;	
		}
		
	}

	@Override
	public Boolean saveChildDetails(ChildDetailsDto childDetailsDto) {
		ChildDetailsEntity entity=new ChildDetailsEntity();
		BeanUtils.copyProperties(childDetailsDto, entity);
		ChildDetailsEntity childData = childRepo.save(entity);
		if(childData!=null) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public ChildDetailsDto editChildDetails(Integer id) {
		Optional<ChildDetailsEntity> findById = childRepo.findById(id);
		if(findById.isPresent()) {
			ChildDetailsDto childDetailsDto=new ChildDetailsDto();
			childDetailsEntity = findById.get();
			BeanUtils.copyProperties(findById, childDetailsDto);
			return childDetailsDto;
		}else {
			return null;
		}
		
	}

	@Override
	public Boolean UpdateChildDetails(ChildDetailsDto childDetailsDto) {
		ChildDetailsEntity entity=new ChildDetailsEntity();
		BeanUtils.copyProperties(childDetailsDto,entity);
		ChildDetailsEntity isUpdate = childRepo.save(entity);
		if(isUpdate!=null) {
			return true;
		}else {
			return null;
		}
		
		
	}

	@Override
	public List<ChildDetailsDto> getAllChilds() {
		List<ChildDetailsEntity> allChildEntity = childRepo.findAll();
		List<ChildDetailsDto> allChilds=new ArrayList<>();
		allChildEntity.forEach(enity->{
			ChildDetailsDto childDetailsDto=new ChildDetailsDto();
			BeanUtils.copyProperties(enity, childDetailsDto);
			allChilds.add(childDetailsDto);
		});
		return allChilds;
	}

	@Override
	public Boolean deleteChild(Integer id) {
		childRepo.deleteById(id);
		return true;
	}

}
