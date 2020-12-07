package com.ies.admin.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ies.admin.entity.AdminAccountEntity;
@Repository
public interface AdminRepository extends JpaRepository<AdminAccountEntity, Serializable>{
    
	public AdminAccountEntity findByEmailAdd(String email);
	public List<AdminAccountEntity> findByRole(String role);
	@Query("UPDATE AdminAccountEntity p set p.status = true WHERE p.srNo = ?1")
	@Modifying
	public void softDelete(Integer id);
}
