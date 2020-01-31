package com.mark.orm;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mark.dao.BaseDaoImp;
import com.mark.dao.EmployeeDao;
import com.mark.entities.Employee;


@Repository("employeeDaoImp")
public class EmployeeDaoImp extends BaseDaoImp<Employee> implements EmployeeDao{


	
}
