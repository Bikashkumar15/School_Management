package com.school.management.repository.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@Table(name = "CATEGORYMASTER",uniqueConstraints = @UniqueConstraint(columnNames = {"CATEGORYNAME"}))
public class CategoryTypeMasterEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="CATEGORYID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoryId;
	
	@Column(name="CATEGORYNAME",unique = true)
	private String categoryName;
	

	
}
