package com.hrms.Hrms.business.abstracts;

import java.util.List;

import com.hrms.Hrms.core.utilities.results.DataResult;
import com.hrms.Hrms.core.utilities.results.Result;
import com.hrms.Hrms.entities.concretes.Users;

public interface UsersService {
	
	DataResult<List<Users>> getAll();
	DataResult<Users> getUserWithEmail(String email);
	Result add(Users users);
}
