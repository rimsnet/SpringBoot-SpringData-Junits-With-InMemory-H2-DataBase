package com.rimsan.springboot.data.inmemory.service;

import com.rimsan.springboot.data.inmemory.entities.Employee;

public interface EmployeeService {
	
	public void saveEmployee(Employee employee);
	
	public Employee getEmployeeById(long id);
	
	

}
