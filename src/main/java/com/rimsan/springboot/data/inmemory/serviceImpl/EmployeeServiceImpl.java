package com.rimsan.springboot.data.inmemory.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rimsan.springboot.data.inmemory.entities.Employee;
import com.rimsan.springboot.data.inmemory.repo.EmployeeRepository;
import com.rimsan.springboot.data.inmemory.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void saveEmployee(Employee employee) {
		
			employeeRepository.save(employee);

	}

	@Override
	public Employee getEmployeeById(long id) {
		Employee empResponse = null;
		
		empResponse = employeeRepository.getEmbloyeById(id);

		return empResponse;
	}

	
	

}
