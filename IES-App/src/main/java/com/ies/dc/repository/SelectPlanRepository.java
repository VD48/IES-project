package com.ies.dc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ies.dc.entity.SelectPlanEntity;
@Repository
public interface SelectPlanRepository extends JpaRepository<SelectPlanEntity, Serializable>{

}
