package com.niit.middleware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.backend.model.Employee;
import com.niit.backend.service.EmpService;

//@CrossOrigin	
@RestController
@RequestMapping("/api/emp")
@CrossOrigin(origins="http://localhost:4200")

public class emplController {
	
	@Autowired
	private EmpService EmplService;
	
	@GetMapping
	public List<Employee> getEmployeeList()
	{
		List<Employee> emp = EmplService.getEmployeeList();
		return emp;
	}
	
	@PostMapping
	public ResponseEntity<Void> addEmployee(@RequestBody Employee emp)
	{
		if(EmplService.getEmployee(emp.getEmplId())==null)
		{
			EmplService.updateEmployee(emp);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping
	public ResponseEntity<Void> updateEmployee(@RequestBody Employee emp)
	{
		if(EmplService.getEmployee(emp.getEmplId())!=null)
		{
			EmplService.updateEmployee(emp);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping ("/{emplId}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("emplId") int emplId)
	{
		System.out.println("In delete mapping");
		if(EmplService.getEmployee(emplId)!=null)
		{
			EmplService.deleteEmployee(emplId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{emplId}")
	public ResponseEntity<Employee> getById(@PathVariable("emplId") int emplId)
	{
		Employee emp = null;
		return new ResponseEntity<Employee>(EmplService.getEmployee(emplId),HttpStatus.OK);
	}
	
	
	

}
