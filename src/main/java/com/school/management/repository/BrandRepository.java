package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.management.repository.persistence.BrandMasterEntity;

@Repository
public interface BrandRepository extends JpaRepository<BrandMasterEntity, Long> {
	boolean existsByBrandName(String brandName);

}
