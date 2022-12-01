package com.school.management.adapter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.management.model.MasterPayload;
import com.school.management.repository.BrandRepository;
import com.school.management.repository.CategoryTypeRepository;
import com.school.management.repository.persistence.BrandMasterEntity;
import com.school.management.repository.persistence.CategoryTypeMasterEntity;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Transactional
public class ProductAdapter {

	final BrandRepository brandRepository;
	
	final CategoryTypeRepository categoryTypeRepository;
	@Autowired
	public ProductAdapter(BrandRepository brandRepository,CategoryTypeRepository categoryTypeRepository) {
		this.brandRepository=brandRepository;
		this.categoryTypeRepository=categoryTypeRepository;
		
	}

	public List<MasterPayload> uploadBrandType(List<MasterPayload> masterPayload) {
		Set<String> categories=new HashSet<>();
		for (MasterPayload mpayload : masterPayload) {
			if(mpayload.getBrandName()!=null && !brandRepository.existsByBrandName(mpayload.getBrandName()))
			brandRepository.save(BrandMasterEntity.builder().brandName(mpayload.getBrandName()).build());
			categories.addAll(mpayload.getItemCategoryType());
			
		}
		categories 
		.stream()
		.filter(c->c!=null && c.trim().length()>0)
		.filter(c->!categoryTypeRepository.existsByCategoryName(c))
		.map(catagory->CategoryTypeMasterEntity.builder().categoryName(catagory).build())
		.forEach(categoryTypeRepository::save);
		return masterPayload;
	}
	
	
	
	//Approach-1
	/*
	 * for(String catagory: mpayload.getItemCategoryType()) {
	 * CategoryTypeMasterEntity
	 * categoryTypeMasterEntity=CategoryTypeMasterEntity.builder().categoryName(
	 * catagory).build(); categoryTypeRepository.save(categoryTypeMasterEntity); }
	 */
	
	//Approach-2
	/*
	 * masterPayload.stream().forEach(pb->{
	 * brandRepository.save(BrandMasterEntity.builder().brandName(pb.getBrandName())
	 * .build()); pb.getItemCategoryType() .stream()
	 * .map(catagory->CategoryTypeMasterEntity.builder().categoryName(catagory).
	 * build()) .forEach(categoryTypeRepository::save); });
	 */
	
	

}
