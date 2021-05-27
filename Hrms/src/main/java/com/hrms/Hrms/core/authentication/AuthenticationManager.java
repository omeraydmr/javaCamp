package com.hrms.Hrms.core.authentication;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.hrms.Hrms.core.utilities.results.Result;
import com.hrms.Hrms.core.utilities.results.SuccessResult;

@Service
public class AuthenticationManager implements AuthenticationService {

	@Override
	public Result sendLink(String email) {
		UUID uuid = UUID.randomUUID();
		String verificationLink = "https://hrmsverification/" + uuid.toString();
		System.out.println("Verification mail has been send to : " + email);
		System.out.println("Click on the link and verify your account: " + verificationLink);
		return new SuccessResult("Verification mail has been send to : " + email + " \n Click on the link and verify your account: " + verificationLink);
	}

	@Override
	public void sendCode(String email) {
		UUID uuid = UUID.randomUUID();
		String verificationCode = uuid.toString();
		System.out.println("Verification link has been sen to : " + email);
		System.out.println("Your activation code : " + verificationCode);
		
	}

}
