package com.hrms.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.Hrms.entities.concretes.JobTitles;

public interface JobTitlesDao extends JpaRepository<JobTitles,Integer>{
	
	JobTitles findWithTitle(String title);
}
