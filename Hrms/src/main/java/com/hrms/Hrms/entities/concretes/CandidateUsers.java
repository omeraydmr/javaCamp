package com.hrms.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidatesUsers")
public class CandidateUsers extends Users{
		
	@Id		
	@Column(name = "user_id")
	private int id;
		
	@Column(name = "first_name")
	private String firstName;
	

	@Column(name = "last_name")
	private String lastName;
	
	
	@Column(name = "nationality_name")
	private String nationalityId;
	
	
	@Column(name = "birth_year")
	private String birthYear;
}
	
