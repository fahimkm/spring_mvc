package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.EmployeeDao;
import com.model.Employee;

@Controller
public class EmployeeController {
	
	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeController(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@PostMapping("/addEmployee")
	public ModelAndView addEmployee(@ModelAttribute Employee employee) {
		employeeDao.addEmployee(employee);
		ModelAndView modelAndView = new ModelAndView("redirect:/employeeform");
		return modelAndView;
	}
	
	
	@GetMapping("/employeeform")
	public String showEmployeeForm(Model model) {
		List<Employee> employees = employeeDao.getEmployees();
		model.addAttribute("employees", employees);
		return "employee_form";
	}
	
	@GetMapping("/removeemployee")
	public String deleteEmployee(@RequestParam("empID") int empID) {
		employeeDao.deleteEmployee(empID);
		return "redirect:/employeeform";
	}
	
	int updateEmpID = 0;
	@GetMapping("/update")
	public String getEmployeeID(@RequestParam("empID") int empID) {
	updateEmpID = empID;
	return "update";
	}
	
	@PostMapping("/update1")
	public String setUpdate(@RequestParam("name") String name,
		@RequestParam("salary") double salary){
		 employeeDao.updateEmployee(name,salary,updateEmpID);
	return "redirect:/employeeform";
	}
	
	
	
}
