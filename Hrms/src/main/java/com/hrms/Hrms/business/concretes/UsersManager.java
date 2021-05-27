package com.hrms.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Hrms.business.abstracts.UsersService;
import com.hrms.Hrms.business.constants.Message;
import com.hrms.Hrms.core.utilities.results.DataResult;
import com.hrms.Hrms.core.utilities.results.Result;
import com.hrms.Hrms.core.utilities.results.SuccessDataResult;
import com.hrms.Hrms.core.utilities.results.SuccessResult;
import com.hrms.Hrms.dataAccess.abstracts.UsersDao;
import com.hrms.Hrms.entities.concretes.Users;

@Service
public class UsersManager implements UsersService{

	private UsersDao usersDao;
	
	@Autowired
	public UsersManager(UsersDao usersDao) {
		super();
		this.usersDao = usersDao;
	}

	@Override
	public DataResult<List<Users>> getAll() {
		return new SuccessDataResult<List<Users>>(this.usersDao.findAll(), Message.USER_LISTED);
	}

	@Override
	public DataResult<Users> getUserWithEmail(String email) {
		return new SuccessDataResult<Users>(this.usersDao.findUserWithEmail(email));
	}

	@Override
	public Result add(Users user) {
		this.usersDao.save(user);
		return new SuccessResult(Message.USER_ADDED);
	}

}
