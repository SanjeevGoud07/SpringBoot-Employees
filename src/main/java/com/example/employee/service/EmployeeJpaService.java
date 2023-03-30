/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 * 
 */

// Write your code here

package com.example.employee.service;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.EmployeeJpaRepository;

import java.util.*;

import com.example.employee.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class EmployeeJpaService implements EmployeeRepository{
    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;
	private Employee save;

	@Override
	public ArrayList<Employee> getEmployees() {
		// TODO Auto-generated method stub
		// return null;
		List<Employee> employeeList=employeeJpaRepository.findAll();
        ArrayList<Employee> employees=new ArrayList<>(employeeList);
        return employees;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		// return null;
		try{
			Employee employee=employeeJpaRepository.findById(employeeId).get();
			return employee;
		}catch(Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		// return null;
		employeeJpaRepository.save(employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(int employeeId, Employee employee) {
		// TODO Auto-generated method stub
		// return null;
		try{
			Employee newEmployee=employeeJpaRepository.findById(employeeId).get();
			if(employee.getEmployeeName()!=null){
				newEmployee.setEmployeeName(employee.getEmployeeName());
			}
			if(employee.getEmail()!=null){
				newEmployee.setEmail(employee.getEmail());
			}
			if(employee.getDepartment()!=null){
				newEmployee.setDepartment(employee.getDepartment());
			}
			employeeJpaRepository.save(newEmployee);
			return newEmployee;
		}catch(Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		// return null;
		try{
			employeeJpaRepository.deleteById(employeeId);
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}


}