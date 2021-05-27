package com.hrms.Hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Hrms.business.abstracts.CandidateUsersService;
import com.hrms.Hrms.business.abstracts.EmployerUsersService;
import com.hrms.Hrms.business.abstracts.UsersService;
import com.hrms.Hrms.business.abstracts.VerificationService;
import com.hrms.Hrms.business.constants.Message;
import com.hrms.Hrms.core.utilities.adapters.UserValidationService;
import com.hrms.Hrms.core.utilities.results.ErrorResult;
import com.hrms.Hrms.core.utilities.results.Result;
import com.hrms.Hrms.core.utilities.results.SuccessResult;
import com.hrms.Hrms.entities.concretes.CandidateUsers;
import com.hrms.Hrms.entities.concretes.EmployerUsers;
import com.hrms.Hrms.core.authentication.AuthenticationService;

@Service
public class VerificationManager implements VerificationService{
	
	private UsersService usersService;
	private CandidateUsersService candidateUsersService;
	private UserValidationService userValidationService;
	private AuthenticationService authenticationService;
	private EmployerUsersService employerUsersService;
	
	@Autowired
	public VerificationManager(
			UsersService usersService,
			CandidateUsersService candidateUsersService,
			UserValidationService userValidationService,
			AuthenticationService authenticationService,
			EmployerUsersService employerUsersService
			) 
	{
		this.usersService = usersService;
		this.candidateUsersService = candidateUsersService;
		this.userValidationService = userValidationService;
		this.authenticationService = authenticationService;
		this.employerUsersService = employerUsersService;
		
	}
	
	@Override
	public Result registerCandidateUsers(CandidateUsers candidateUsers) {
		
		if (checkIfRealPerson(candidateUsers.getFirstName(), candidateUsers.getLastName(), candidateUsers.getNationalityId(), candidateUsers.getBirthYear()) == false){
			return new ErrorResult(Message.MERNIS_VERIFICATION_ERROR);
		}
		if (!checkIfNullValueInCandidates(candidateUsers)) {
			return new ErrorResult(Message.CANDIDATE_NULL_ERROR);
		}
		if(!checkIfExistIdentityNumber(candidateUsers.getNationalityId())) {
			return new ErrorResult(candidateUsers.getNationalityId() + Message.CANDIDATE_IDENTITY_NUMBER_ERROR);
		}
		if(!checkIfEmailExist(candidateUsers.getEmail())) {
			return new ErrorResult(candidateUsers.getEmail() + Message.CANDIDATE_EMAIL_ERROR);
		}
		
		authenticationService.sendLink(candidateUsers.getEmail());
		candidateUsersService.add(candidateUsers);
		return new SuccessResult(Message.CANDIDATE_REGISTIRATION_COMPLETED);		
	}
	
	@Override
	public Result registerEmployerUsers(EmployerUsers employerUsers) {
		
		if (!checkIfNullValueInEmployer(employerUsers)) {
			return new ErrorResult(Message.EMPLOYER_LISTED);
		}
		
		if (!checkIfEqualEmailAndDomain(employerUsers.getEmail(), employerUsers.getWebSite())) {
			return new ErrorResult(Message.EMPLOYER_EMAIL_ERROR);
		}
		
		if(!checkIfEmailExist(employerUsers.getEmail())) {
			return new ErrorResult(employerUsers.getEmail() + Message.EMPLOYER_EMAIL_EXIST_ERROR);
		}
		
		authenticationService.sendLink(employerUsers.getEmail());
		employerUsersService.add(employerUsers);
		return new SuccessResult(Message.EMPLOYER_REGISTIRATION_COMPLETED);
		
	}
	
	//Candidate Validation
	
	private boolean checkIfNullValueInCandidates(CandidateUsers candidateUsers) {
		if (candidateUsers.getFirstName() != null &&
			candidateUsers.getLastName() != null &&
			candidateUsers.getBirthYear() != null &&
			candidateUsers.getPassword() != null &&
			candidateUsers.getEmail() != null
			) 
		{
			return true;
		}
		
		return false;
	}
	
	private boolean checkIfExistIdentityNumber(String nationalityId) {
		if (this.candidateUsersService.getCandidatesWithIdentityNumber(nationalityId).getData() == null) {
			return true;
		}
		return false;
	}
	
	private boolean checkIfRealPerson(String firstName, String lastName, String nationalityId, String birthOfYear) {
		if (userValidationService.checkIfRealPerson(firstName, lastName, nationalityId, birthOfYear)) {
			return true;
		}
		return false;
	}
	
	//Employer Validation
	
	private boolean checkIfNullValueInEmployer(EmployerUsers employerUsers) {
		if (employerUsers.getCompanyName() != null &&
			employerUsers.getWebSite() != null &&
			employerUsers.getEmail() != null &&
			employerUsers.getPhoneNumber() != null &&
			employerUsers.getPassword() != null
		   ) 
		{
			return true;
		}
		
		return false;
	}
	
	private boolean checkIfEqualEmailAndDomain(String email, String webAddress) {
		
		String[] emailArray = email.split("@",2);
		String domain = webAddress.substring(4, webAddress.length());
		
		if (emailArray[1].equals(domain)) {
			return true;
		}
		
		return false;
		
	}
	
	//Common Validation
	
	private boolean checkIfEmailExist(String email) {
		if (this.usersService.getUserWithEmail(email).getData() == null) {
			return true;
		}
		
		return false;
	}
}
