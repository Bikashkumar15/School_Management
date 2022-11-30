package com.school.management.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.model.AdminRequestPayload;
import com.school.management.repository.AdminRepository;
import com.school.management.repository.persistence.AdminEntity;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j

public class SchoolManagementController {
	@Autowired
	private AdminRepository adminRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<?> saveAdminDetails(@RequestBody AdminRequestPayload admin) {
		log.info("---------------------------------------------------");
		AdminEntity adminEntity = AdminEntity.builder()
				.firstName(admin.getFirstName())
				.lastName(admin.getLastName())
				.userName(admin.getUserName())
				.passWord(admin.getPassWord())
				.build();
		adminEntity = adminRepository.save(adminEntity);
		return ResponseEntity.ok(adminEntity);
	}
}
