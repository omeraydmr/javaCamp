package com.hrms.Hrms.core.utilities.adapters;

public interface UserValidationService {
	
	boolean checkIfRealPerson(String firstName, String lastName, String nationalityId, String birthYear);
}
