package com.hrms.Hrms.business.abstracts;

import com.hrms.Hrms.core.utilities.results.Result;
import com.hrms.Hrms.entities.concretes.CandidateUsers;
import com.hrms.Hrms.entities.concretes.EmployerUsers;

public interface VerificationService {
	
	Result registerCandidateUsers(CandidateUsers candidate);
	Result registerEmployerUsers(EmployerUsers employer);
}
