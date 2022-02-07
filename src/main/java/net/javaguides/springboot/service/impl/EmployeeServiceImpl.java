package net.javaguides.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository= employeeRepository;
		
	}
	
	
	//to save the employee to the DB POST
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	//to get all emp from DB GET
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
		
	}


	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
	}


	@Override
	public Employee updateEmployee(Employee employee, long id) {
		//check if the employee with the ide in DB
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee", "Id",id));
		
		existingEmployee.setFname(employee.getFname());
		existingEmployee.setLname(employee.getLname());
		existingEmployee.setEmail(employee.getEmail());
		
		//save existing emp to DB
		
		employeeRepository.save(existingEmployee);
		return existingEmployee;
		
	}


	@Override
	public void deleteEmployee(long id) {
		//check if emp in DB
		employeeRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
		
	}
	
	
	
	
	
	
	
	
	
	
}
