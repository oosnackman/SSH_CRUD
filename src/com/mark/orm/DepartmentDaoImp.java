package com.mark.orm;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mark.dao.BaseDaoImp;
import com.mark.dao.DepartmentDao;
import com.mark.entities.Department;
import com.mark.entities.Employee;

@Repository("departmentDao")
public class DepartmentDaoImp extends BaseDaoImp<Department> implements DepartmentDao{

}
