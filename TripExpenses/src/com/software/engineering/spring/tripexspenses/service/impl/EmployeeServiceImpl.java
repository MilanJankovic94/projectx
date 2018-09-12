package com.software.engineering.spring.tripexspenses.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.software.engineering.spring.tripexspenses.dao.EmployeeDAO;
import com.software.engineering.spring.tripexspenses.domen.Employee;
import com.software.engineering.spring.tripexspenses.service.EmployeesService;

@Service("employeesService")
public class EmployeeServiceImpl implements EmployeesService{
	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDAO.findAll();
	}

	@Override
	public void delete(Long employeeId) {
		employeeDAO.delete(employeeId);
		
	}


	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.save(employee);
	}

	@Override
	public Employee findByID(Long employeeId) {
		// TODO Auto-generated method stub
		return employeeDAO.findOne(employeeId);
	}

}