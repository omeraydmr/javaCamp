package com.hrms.Hrms.core.utilities.adapters;

import com.hrms.Hrms.MERNIS.MernisManager;

public class MernisServiceAdapter implements UserValidationService{

	@Override
	public boolean checkIfRealPerson(String firstName, String lastName, String nationalityId, String birthYear) {
		
		MernisManager mernisManager = new MernisManager();
		
		boolean result = mernisManager.validateUser(firstName, lastName, nationalityId, birthYear);
		
		if(result) {
			System.out.println("Person is  valid person.");
			return true;
		}
		else {
			return true;
		}
	}
}	


