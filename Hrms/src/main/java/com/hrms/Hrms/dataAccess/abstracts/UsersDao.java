package com.hrms.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.Hrms.entities.concretes.Users;

public interface UsersDao extends JpaRepository<Users,Integer> {
	
	Users findUserWithEmail(String email);

}
