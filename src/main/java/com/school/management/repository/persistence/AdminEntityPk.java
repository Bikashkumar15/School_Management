package com.school.management.repository.persistence;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class AdminEntityPk implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4441509557662836578L;
	private String userName;
	private String passWord;

}
