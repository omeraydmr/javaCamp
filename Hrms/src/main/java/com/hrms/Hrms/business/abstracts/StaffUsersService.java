package com.hrms.Hrms.business.abstracts;

import java.util.List;

import com.hrms.Hrms.core.utilities.results.DataResult;
import com.hrms.Hrms.entities.concretes.StaffUsers;

public interface StaffUsersService {
	
	DataResult<List<StaffUsers>> getAll();
}
