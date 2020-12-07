 package com.ies.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ies.admin.domain.PlanRegister;
import com.ies.admin.entity.PlanRegisterEntity;
import com.ies.admin.repository.PlanRepository;
@Service
public class PlanServiceImpl  implements PlanService{
	@Autowired
	private PlanRepository planRepo;

	@Override
	public Boolean savePlan(PlanRegister planRegister) {
		PlanRegisterEntity entity=new PlanRegisterEntity();
		BeanUtils.copyProperties(planRegister, entity);
		System.out.println(entity.getPlanEndDate()+"0000000000000000000000000000");
		PlanRegisterEntity planEntity = planRepo.save(entity);
		if(planEntity!=null) {
			return true;
		}else {
			throw new RuntimeException();
		}
		
		
		
	}

	@Override
	public List<PlanRegister> getAllPlan() {
		List<PlanRegisterEntity> planEntityList = planRepo.findAll();
		List<PlanRegister> planList=new ArrayList<>();
		planEntityList.forEach(entity->{
			PlanRegister planRegister=new PlanRegister();
			BeanUtils.copyProperties(entity, planRegister);
			planList.add(planRegister);
		});
		return planList;
	}

	@Override
	public PlanRegister editPlan(int planNo) {
		Optional<PlanRegisterEntity> entity = planRepo.findById(planNo);
		
		if(entity.isPresent()) {
			PlanRegisterEntity planEntity = entity.get();
			PlanRegister planRegister=new PlanRegister();
			BeanUtils.copyProperties(planEntity, planRegister);
			return planRegister;
		}else {
			throw new RuntimeException("plan not found");
		}
		
	}

	@Override
	public Boolean updatePlan(PlanRegister planRegister) {
		PlanRegisterEntity entity=new PlanRegisterEntity();
		BeanUtils.copyProperties(planRegister, entity);
		PlanRegisterEntity saveEntity = planRepo.save(entity);
		if(saveEntity!=null) {
			return true;
		}else {
			throw new RuntimeException();
		}
		
	}

	@Override
	@Transactional
	public Boolean deletePlaN(Integer id) {
		if(id!=0) {
		planRepo.softDeletePlan(id);
		return true;
		}else {
			return false;
		}
		
	}

}
