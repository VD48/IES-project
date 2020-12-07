package com.ies.dc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.dc.entity.CaseFormEntity;

public interface CaseRepository extends JpaRepository<CaseFormEntity, Serializable>{

}
