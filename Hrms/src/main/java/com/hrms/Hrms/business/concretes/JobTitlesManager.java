package com.hrms.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.Hrms.business.abstracts.JobTitlesService;
import com.hrms.Hrms.business.constants.Message;
import com.hrms.Hrms.core.utilities.results.DataResult;
import com.hrms.Hrms.core.utilities.results.ErrorResult;
import com.hrms.Hrms.core.utilities.results.Result;
import com.hrms.Hrms.core.utilities.results.SuccessDataResult;
import com.hrms.Hrms.core.utilities.results.SuccessResult;
import com.hrms.Hrms.dataAccess.abstracts.JobTitlesDao;
import com.hrms.Hrms.entities.concretes.JobTitles;

@Service
public class JobTitlesManager implements JobTitlesService{
	
	private JobTitlesDao jobTitlesDao;
	
	@Autowired
	public JobTitlesManager(JobTitlesDao jobTitlesDao) {
		super();
		this.jobTitlesDao = jobTitlesDao;
	}

	@Override
	public DataResult<List<JobTitles>> getAll() {
		return new SuccessDataResult<List<JobTitles>>(this.jobTitlesDao.findAll(), Message.JOB_TITLES_LISTED);
	}

	@Override
	public DataResult<JobTitles> getWithJobTitle(String titleName) {
		return new SuccessDataResult<JobTitles>(this.jobTitlesDao.findWithTitle(titleName));
	}

	@Override
	public Result add(JobTitles jobTitle) {
		if (getWithJobTitle(jobTitle.getTitleName()).getData() != null) {
			return new ErrorResult(Message.JOB_TITLE_EXIST);
		}
		
		this.jobTitlesDao.save(jobTitle);
		return new SuccessResult(Message.JOB_TITLE_ADDED);
	}

}
