package com.ies.co.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ies.co.entities.CoTriggers;
@Repository
public interface CoRepository extends JpaRepository<CoTriggers,Serializable> {
  public List<CoTriggers> findByTrgStatus(String trgStatus);
  
}
