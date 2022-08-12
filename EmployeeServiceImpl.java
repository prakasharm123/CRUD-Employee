package net.javaguides.springboot.service.impl;

import java.util.List;
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
		this.employeeRepository = employeeRepository;
	}




	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub 
		return employeeRepository.save(employee);
	}




	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll();
	}




	@Override
	public Employee getEmployeeByID(long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee","Id",id);
//		}
		
		return employeeRepository.findById(id).orElseThrow(()  -> new ResourceNotFoundException("Employee", "Id", id));
	}




	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		//we need to check whether employee with given id exist in DB or not
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setFirstName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		//save existing employee to DB
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}




	@Override
	public void deleteEmployeeById(long id) {
		
		//we need to check whether employee with given id exist in DB or not
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","id" , id));
		employeeRepository.deleteById(id);
		
	}




	

}
