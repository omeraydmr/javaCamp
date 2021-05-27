package com.hrms.Hrms.business.abstracts;

import java.util.List;

import com.hrms.Hrms.core.utilities.results.DataResult;
import com.hrms.Hrms.core.utilities.results.Result;
import com.hrms.Hrms.entities.concretes.EmployerUsers;

public interface EmployerUsersService {
	
	DataResult<List<EmployerUsers>> getAll();
	Result add(EmployerUsers employerUsers);
}
