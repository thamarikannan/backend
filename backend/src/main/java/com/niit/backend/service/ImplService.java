package com.niit.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.niit.backend.dao.Empdao;
import com.niit.backend.model.Employee;

@Repository("EmplService")
@Transactional
@Service

public class ImplService implements EmpService{
	
	@Autowired
	private Empdao empdao;

	@Override
	public List<Employee> getEmployeeList() {
	
		return empdao.getEmployeeList();
	}

	@Override
	public Employee getEmployee(int emplId) {
		
		return empdao.getEmployee(emplId);
	}

	@Override
	public boolean addEmployee(Employee emp) {
		empdao.addEmployee(emp);
		
		return true;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		empdao.updateEmployee(emp);
		
		return true;
	}

	@Override
	public boolean deleteEmployee(int emplId) {
		empdao.deleteEmployee(emplId);
	
		return false;
	}

	@Override
	public Employee findbyId(int emplId) {
		

		return empdao.getEmployee(emplId);
	}
	

}
