package com.ies.dc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ies.dc.entity.ChildDetailsEntity;
@Repository
public interface ChildDetailsRepository extends JpaRepository<ChildDetailsEntity, Serializable> {

}
