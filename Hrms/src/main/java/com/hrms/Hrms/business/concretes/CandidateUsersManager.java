package com.hrms.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Hrms.business.abstracts.CandidateUsersService;
import com.hrms.Hrms.business.constants.Message;
import com.hrms.Hrms.core.utilities.results.DataResult;
import com.hrms.Hrms.core.utilities.results.Result;
import com.hrms.Hrms.core.utilities.results.SuccessDataResult;
import com.hrms.Hrms.core.utilities.results.SuccessResult;
import com.hrms.Hrms.dataAccess.abstracts.CandidateUsersDao;
import com.hrms.Hrms.entities.concretes.CandidateUsers;

@Service
public class CandidateUsersManager implements CandidateUsersService{
	
	private CandidateUsersDao candidateUsersDao;
	
	@Autowired
	public CandidateUsersManager(CandidateUsersDao candidateUsersDao) {
		this.candidateUsersDao = candidateUsersDao;
	}
	
	@Override
	public DataResult<List<CandidateUsers>> getAll() {
		return new SuccessDataResult<List<CandidateUsers>>(this.candidateUsersDao.findAll(), Message.CANDIDATE_LISTED);
	}

	@Override
	public DataResult<CandidateUsers> getCandidatesWithIdentityNumber(String nationalityId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<CandidateUsers>(this.candidateUsersDao.findWithIdentityNumber(nationalityId));
	}

	@Override
	public Result add(CandidateUsers candidateUsers) {
		this.candidateUsersDao.save(candidateUsers);
		return new SuccessResult(Message.CANDIDATE_ADDED);
	}

}
