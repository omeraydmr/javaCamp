package com.hrms.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "employersUsers")
@AllArgsConstructor
@NoArgsConstructor
public class EmployerUsers extends Users{
		
	@Id
	@Column(name = "user_id")
	private int id;
		
	@Column(name = "company_name")
	private String companyName;
	

	@Column(name = "web_site")
	private String webSite;
	
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	
	@Column(name = "is_verified")
	private String isVerified;
}
