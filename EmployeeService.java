package net.javaguides.springboot.service;


import java.util.List;

import net.javaguides.springboot.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmployeeByID(long id);
	Employee updateEmployee(Employee employee, long id);
	void deleteEmployeeById(long id);
	
	
	
	

}
