package com.hrms.Hrms.business.abstracts;

import java.util.List;

import com.hrms.Hrms.core.utilities.results.DataResult;
import com.hrms.Hrms.core.utilities.results.Result;
import com.hrms.Hrms.entities.concretes.CandidateUsers;

public interface CandidateUsersService {
	
	DataResult<List<CandidateUsers>> getAll();
	DataResult<CandidateUsers> getCandidatesWithIdentityNumber(String nationalityId);
	Result add(CandidateUsers candidateUsers);
}
