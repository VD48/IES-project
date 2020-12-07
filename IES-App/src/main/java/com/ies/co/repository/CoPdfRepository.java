package com.ies.co.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ies.co.entities.CoPdf;
@Repository
public interface CoPdfRepository extends JpaRepository<CoPdf,Serializable> {

}
