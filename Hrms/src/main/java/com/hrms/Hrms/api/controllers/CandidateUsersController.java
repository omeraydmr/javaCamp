package com.hrms.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.Hrms.business.abstracts.CandidateUsersService;
import com.hrms.Hrms.core.utilities.results.DataResult;
import com.hrms.Hrms.entities.concretes.CandidateUsers;

public class CandidateUsersController {

	@RestController
	@RequestMapping("/api/candidateusers")
	public class CandidateController {
		
		private CandidateUsersService candidateUsersService;
		
		@Autowired
		private CandidateController(CandidateUsersService candidateUsersService) {
			this.candidateUsersService = candidateUsersService;
		}
		
		@GetMapping("/getall")
		public DataResult<List<CandidateUsers>> getAll(){
			return this.candidateUsersService.getAll();
		}
	}
}
