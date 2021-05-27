package com.hrms.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Hrms.business.abstracts.StaffUsersService;
import com.hrms.Hrms.business.constants.Message;
import com.hrms.Hrms.core.utilities.results.DataResult;
import com.hrms.Hrms.core.utilities.results.SuccessDataResult;
import com.hrms.Hrms.dataAccess.abstracts.StaffUsersDao;
import com.hrms.Hrms.entities.concretes.StaffUsers;

@Service
public class StaffUsersManager implements StaffUsersService{
	
	private StaffUsersDao staffUsersDao;
	
	@Autowired
	public StaffUsersManager(StaffUsersDao staffUsersDao) {
		super();
		this.staffUsersDao = staffUsersDao;
	}

	@Override
	public DataResult<List<StaffUsers>> getAll() {
		return new SuccessDataResult<List<StaffUsers>>(this.staffUsersDao.findAll(), Message.EMPLOYEE_LISTED);
	}
}
