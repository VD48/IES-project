package com.ies.applicationregister.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ies.applicationregister.entity.ApplicantRegisterEntity;
@Repository
public interface ApplicantRepository extends JpaRepository<ApplicantRegisterEntity, Serializable>{
	@Query("UPDATE ApplicantRegisterEntity a set a.status = true WHERE a.applicantRegNo = ?1")
	@Modifying
   public void softDeletePlan(String applicantRegNo );
}
