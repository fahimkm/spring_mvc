package com.dao;

import java.util.List;

import com.model.Employee;

public interface EmployeeDao {


	Employee addEmployee(Employee employee);
	Employee getEmployee(int empID);
	List<Employee> getEmployees();
	boolean deleteEmployee(int empID);
	void updateEmployee(String name,double salary,int updateEmpID);

}
