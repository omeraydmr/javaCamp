package com.hrms.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.Hrms.entities.concretes.StaffUsers;

public interface StaffUsersDao extends JpaRepository<StaffUsers, Integer>{

}
