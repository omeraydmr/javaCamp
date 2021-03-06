package com.hrms.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "staffUsers")
public class StaffUsers {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "user_id")
	private int id;
		
	@Column(name = "first_name")
	private String firstName;
	

	@Column(name = "last_name")
	private String lastName;

}
