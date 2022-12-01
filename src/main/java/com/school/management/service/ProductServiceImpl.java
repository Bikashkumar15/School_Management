package com.school.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.adapter.ProductAdapter;
import com.school.management.model.MasterPayload;

@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	ProductAdapter productAdapter;
	
	@Override
	public List<MasterPayload> uploadBrandandItemCategory(List<MasterPayload> masterPayload) {
		// TODO Auto-generated method stub
		return productAdapter.uploadBrandType(masterPayload);
	}

}
