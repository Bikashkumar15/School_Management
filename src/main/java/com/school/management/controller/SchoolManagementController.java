package com.school.management.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.model.AdminRequestPayload;
import com.school.management.model.MasterPayload;
import com.school.management.repository.AdminRepository;
import com.school.management.repository.persistence.AdminEntity;
import com.school.management.service.IProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j

public class SchoolManagementController {
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	IProductService productService;

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
	
	@PostMapping("/uploadbrandandcategory")
	public ResponseEntity<Object> uploadBrandandItemCategory(@RequestBody List<MasterPayload> masterPayload){
		productService.uploadBrandandItemCategory(masterPayload);
		return ResponseEntity.ok(masterPayload);
	}
}
