package com.ies.co.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ies.co.entities.BatchRunDetails;
@Repository
public interface BatchRunRepository extends JpaRepository<BatchRunDetails, Serializable>{

}
