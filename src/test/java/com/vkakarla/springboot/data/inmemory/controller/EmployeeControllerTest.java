package com.vkakarla.springboot.data.inmemory.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rimsan.springboot.data.inmemory.application.JunitsInMemoryH2DbApplication;
import com.rimsan.springboot.data.inmemory.controller.EmployeeController;
import com.rimsan.springboot.data.inmemory.entities.Employee;
import com.rimsan.springboot.data.inmemory.repo.EmployeeRepository;
import com.rimsan.springboot.data.inmemory.serviceImpl.EmployeeServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JunitsInMemoryH2DbApplication.class)
@TestPropertySource(locations = "classpath:application-mock.properties")
public class EmployeeControllerTest {

	@Autowired
	EmployeeController employeeController;

	@Autowired
	EmployeeServiceImpl employeeService;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ObjectMapper objectMapper;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void given_ValidEmpId_when_calling_getEmployee_then_return_employeeDetails() {

		try {

			ResponseEntity<Object> response = employeeController.getEmployee((long) 1001);

			assertNotNull(response);
			assertEquals(HttpStatus.OK, response.getStatusCode());
			Employee employeeDetails = converEmployeeData(response);

			assertEquals(1001, employeeDetails.getId());
			assertEquals("Fathi", employeeDetails.getFirstName());
			assertEquals("As", employeeDetails.getLastName());
			assertEquals("Java", employeeDetails.getDepartment());
			assertEquals("fa@gmail.com", employeeDetails.getEmail());
			assertEquals("MY", employeeDetails.getAddress());
          
		} catch (Exception e) {
			fail();
			e.printStackTrace();
		}

	}
	
	@Test
	public void given_ValidEmpId_when_calling_getEmployee_then_return_employeeDetails2() {

		try {

			ResponseEntity<Object> response = employeeController.getEmployee((long) 1002);

			assertNotNull(response);
			assertEquals(HttpStatus.OK, response.getStatusCode());
			Employee employeeDetails = converEmployeeData(response);

			assertEquals(1002, employeeDetails.getId());
			assertEquals("Ahm", employeeDetails.getFirstName());
			assertEquals("Mans", employeeDetails.getLastName());
			assertEquals("Java-Spring", employeeDetails.getDepartment());
			assertEquals("ah@gmail.com", employeeDetails.getEmail());
			assertEquals("MY", employeeDetails.getAddress());

		} catch (Exception e) {
			fail();
			e.printStackTrace();
		}

	}
	
	@Test
	public void given_ValidEmpId_when_calling_getEmployee_then_return_employeeDetails3() {

		try {

			ResponseEntity<Object> response = employeeController.getEmployee((long) 1003);

			assertNotNull(response);
			assertEquals(HttpStatus.OK, response.getStatusCode());
			Employee employeeDetails = converEmployeeData(response);

			assertEquals(1003, employeeDetails.getId());
			assertEquals("moh", employeeDetails.getFirstName());
			assertEquals("rims", employeeDetails.getLastName());
			assertEquals("Java-SpringBoot", employeeDetails.getDepartment());
			assertEquals("tim@gmail.com", employeeDetails.getEmail());
			assertEquals("MY", employeeDetails.getAddress());

		} catch (Exception e) {
			fail();
			e.printStackTrace();
		}

	}

	private Employee converEmployeeData(ResponseEntity<Object> response) {
		Employee emp = null;
		try {
			String empString = objectMapper.writeValueAsString(response.getBody());
			emp = objectMapper.readValue(empString, new TypeReference<Employee>() {});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return emp;
	}

}
