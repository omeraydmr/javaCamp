package com.hrms.Hrms.core.authentication;

import com.hrms.Hrms.core.utilities.results.Result;

public interface AuthenticationService {
	
	Result sendLink(String email);
	void sendCode(String email);
	
}
