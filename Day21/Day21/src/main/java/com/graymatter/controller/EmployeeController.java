package com.graymatter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.graymatter.model.Employee;

import jakarta.annotation.PostConstruct;

@Controller
@ResponseBody
public class EmployeeController {
	
	List<Employee> empList = new ArrayList<Employee>();
	
	@PostConstruct 
	public void setUpEmpList()
	{
		empList.add(new Employee(123, "Dhanya", 20000));
		empList.add(new Employee(124, "John", 25000));
		empList.add(new Employee(125, "Jane", 30000));
	}
	
	@RequestMapping("/employee")
	public ModelAndView getAllEmployees()
	{
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("empList", empList);
		return mv;
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee emp)
	{
		empList.add(emp);
		return emp;
	}
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable("id") int eid)
	{
		for (Employee e : empList)
		{
			if (e.getEmpId() == eid)
				return e;
		}
		return null;
	}
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee emp, @PathVariable("id") int eid)
	{
		for (Employee e : empList)
		{
			if (e.getEmpId() == eid)
			{
				e.setEmpName(emp.getEmpName());
				e.setEmpSal(emp.getEmpSal());
				return e;
			}
		}
		return null;
	}
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public boolean deleteEmployee(@PathVariable("id") int eid)
	{
		//Employee e=null;
		for (Employee e : empList)
		{
			if (e.getEmpId() == eid)
			{
				empList.remove(e);
				return true;
			}
		}
		return false;
		
		
	}
}
