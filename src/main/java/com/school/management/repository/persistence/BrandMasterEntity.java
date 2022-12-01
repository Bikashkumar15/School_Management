package com.school.management.repository.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "BRAND_MASTER",uniqueConstraints = @UniqueConstraint(columnNames = {"BRANDNAME"}))
public class BrandMasterEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BRANDID")
	private long brandId;
	
	@Column(name="BRANDNAME",unique = true)
	private String brandName;
	
	
	
	

}
