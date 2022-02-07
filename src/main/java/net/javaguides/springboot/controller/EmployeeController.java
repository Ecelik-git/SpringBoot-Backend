package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//employee REST API
	@PostMapping()//to save an employee to the database POST
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	//to get all emp from DB GET
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployee();
	}
	
	
	//get employee by id
	//http://localhost:8080/api/employee/1 or 2 this is id
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
	}
	
	
	//update REST API
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,
			@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.
				updateEmployee(employee, id), HttpStatus.OK);
	}
	
	//delete API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully!", HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
