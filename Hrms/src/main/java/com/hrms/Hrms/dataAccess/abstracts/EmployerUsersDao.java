package com.hrms.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.Hrms.entities.concretes.EmployerUsers;

public interface EmployerUsersDao extends JpaRepository<EmployerUsers, Integer> {

}
