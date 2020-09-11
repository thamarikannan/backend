package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.Employee;

public interface Empdao {
	public List<Employee> getEmployeeList();
	public Employee getEmployee(int emplId);
	public boolean addEmployee(Employee emp);
	public boolean updateEmployee(Employee emp);
	public boolean deleteEmployee(int emplId);
	public Employee findbyId (int emplId);
	

}
