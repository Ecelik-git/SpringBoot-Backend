package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	
	Employee getEmployeeById(Long id);
	
	Employee updateEmployee(Employee employee, long id);
	
	void deleteEmployee(long id);

	

}
