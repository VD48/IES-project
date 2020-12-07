package com.ies.dc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ies.dc.entity.IncomeDetailsEntity;
@Repository
public interface IncomeDetailsRepository extends JpaRepository<IncomeDetailsEntity, Serializable> {

}
