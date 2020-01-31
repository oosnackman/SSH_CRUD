package com.mark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mark.entities.Employee;
import com.mark.orm.EmployeeDaoImp;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDaoImp employeeDaoImp;

	public List<Employee> getAll() {
		return employeeDaoImp.getAll();
	}

	public void delete(int id) {
		employeeDaoImp.delete(id);
	}

	public void save(Employee employee) {
		employeeDaoImp.save(employee);
	}

	public Employee getId(Integer id) {
		return employeeDaoImp.getId(id);

	}

}
