package com.hrms.Hrms.business.abstracts;

import java.util.List;

import com.hrms.Hrms.core.utilities.results.DataResult;
import com.hrms.Hrms.core.utilities.results.Result;
import com.hrms.Hrms.entities.concretes.JobTitles;

public interface JobTitlesService {
	
	DataResult<List<JobTitles>> getAll();
	DataResult<JobTitles> getWithJobTitle(String titleName);
	Result add(JobTitles jobTitle);
}
