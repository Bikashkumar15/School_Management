package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.management.repository.persistence.AdminEntity;
import com.school.management.repository.persistence.AdminEntityPk;
@Repository
public interface AdminRepository  extends JpaRepository<AdminEntity, AdminEntityPk>{

}
