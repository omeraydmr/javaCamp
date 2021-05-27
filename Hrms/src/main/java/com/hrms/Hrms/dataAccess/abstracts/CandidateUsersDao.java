package com.hrms.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.Hrms.entities.concretes.CandidateUsers;

public interface CandidateUsersDao extends JpaRepository<CandidateUsers, Integer>{
	
	CandidateUsers findWithIdentityNumber(String identityNumber);
}
