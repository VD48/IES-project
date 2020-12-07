package com.ies.admin.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ies.admin.entity.PlanRegisterEntity;
@Repository
public interface PlanRepository extends JpaRepository<PlanRegisterEntity,Integer> {
	@Query("UPDATE PlanRegisterEntity p set p.status = true WHERE p.planNo = ?1")
	@Modifying
   public void softDeletePlan(Integer planNo);
   
	   
  
}
