package com.hrms.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Hrms.business.abstracts.EmployerUsersService;
import com.hrms.Hrms.business.constants.Message;
import com.hrms.Hrms.core.utilities.results.DataResult;
import com.hrms.Hrms.core.utilities.results.Result;
import com.hrms.Hrms.core.utilities.results.SuccessDataResult;
import com.hrms.Hrms.core.utilities.results.SuccessResult;
import com.hrms.Hrms.dataAccess.abstracts.EmployerUsersDao;
import com.hrms.Hrms.entities.concretes.EmployerUsers;

@Service
public class EmployerUsersManager implements EmployerUsersService {

	private EmployerUsersDao employerDao;
	
	@Autowired
	public EmployerUsersManager(EmployerUsersDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<EmployerUsers>> getAll() {
		return new SuccessDataResult<List<EmployerUsers>>(this.employerDao.findAll(), Message.EMPLOYEE_LISTED);
	}

	@Override
	public Result add(EmployerUsers employerUsers) {
		this.employerDao.save(employerUsers);
		return new SuccessResult(Message.EMPLOYER_ADDED);
	}

}
