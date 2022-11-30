package com.school.management.repository.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "ADMIN")
@IdClass(AdminEntityPk.class)
public class AdminEntity {
    @Id
	@Column(name="USERNAME")
	private String userName;
	
    @Id
	@Column(name="PASSWORD")
	private String passWord;
 
    
    @Column(name="FIRSTNAME")
    private String firstName;
    
    @Column(name="LASTNAME")
    private String lastName;
    
    
}
