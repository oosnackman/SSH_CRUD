package com.mark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mark.entities.Department;
import com.mark.orm.DepartmentDaoImp;



@Service
public class DepartmentService {

	@Autowired
	DepartmentDaoImp departmentDaoImp;


	public List<Department> getAll() {

		return departmentDaoImp.getAll();
	}

}
