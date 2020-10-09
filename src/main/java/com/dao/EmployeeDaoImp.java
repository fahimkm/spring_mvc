package com.dao;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.model.Employee;

@Repository
public class EmployeeDaoImp implements EmployeeDao{
	private static List<Employee> employeeRepository = new ArrayList<>();
	
	@Override
	public Employee addEmployee(Employee employee) {
		employeeRepository.add(employee);
		return employee;
	}

	@Override
	public Employee getEmployee(int empID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository;
	}

	@Override
	public boolean deleteEmployee(int empID) {
		// TODO Auto-generated method stub
		Iterator<Employee> iterator = employeeRepository.iterator();
		boolean found = false;
		while (iterator.hasNext()) {
			Employee employee = iterator.next();
			if (employee.getEmpID() == empID) {
				iterator.remove();
				found = true;
				break;
			}
		}
		return found;
		
	}

	@Override
	public void updateEmployee(String name,double salary,int updateEmpID) {
		List<Employee> employees = employeeRepository;
		for(Employee employee:employees) {
			if(employee.getEmpID() == updateEmpID) {
				employee.setName(name);
				employee.setSalary(salary);
			}
	}
	}
}

