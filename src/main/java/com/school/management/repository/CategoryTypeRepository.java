package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.management.repository.persistence.CategoryTypeMasterEntity;
@Repository
public interface CategoryTypeRepository extends JpaRepository<CategoryTypeMasterEntity, Long> {
	boolean existsByCategoryName(String categoryName);

}
