package com.ies.ed.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ies.ed.entities.EligibilityDetails;
@Repository
public interface EligibilityDetailsRepostory extends JpaRepository<EligibilityDetails, Serializable>{

}
