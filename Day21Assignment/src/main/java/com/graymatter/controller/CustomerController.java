package com.graymatter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.graymatter.model.Customer;

import jakarta.annotation.PostConstruct;

@Controller
@ResponseBody
public class CustomerController {
	
List<Customer> custList = new ArrayList<Customer>();
	
	@PostConstruct 
	public void setUpEmpList()
	{
		custList.add(new Customer(123, "Dhanya", "abc@gmail.com"));
		custList.add(new Customer(124, "John", "abc@gmail.com"));
		custList.add(new Customer(125, "Jane", "abc@gmail.com"));
	}
	
	@RequestMapping("/customer")
	public ModelAndView getAllCustomers()
	{
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("custList", custList);
		return mv;
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public Customer addCustomer(@RequestBody Customer cust)
	{
		custList.add(cust);
		return cust;
	}
	
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public Customer getCustomerById(@PathVariable("id") int eid)
	{
		for (Customer e : custList)
		{
			if (e.getId() == eid)
				return e;
		}
		return null;
	}
	
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
	public Customer updateCustomer(@RequestBody Customer cust, @PathVariable("id") int eid)
	{
		for (Customer e : custList)
		{
			if (e.getId() == eid)
			{
				e.setName(cust.getName());
				e.setEmail(cust.getEmail());
				return e;
			}
		}
		return null;
	}
	
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
	public String deleteCustomer(@PathVariable("id") int eid)
	{
		//Customer e=null;
		for (Customer e : custList)
		{
			if (e.getId() == eid)
			{
				custList.remove(e);
				return "Customer deleted";
			}
		}
		return "Customer not found";	
	}
	
	@RequestMapping("/login")
	public ModelAndView doLogin(@RequestParam String uname, @RequestParam String pwd)
	{
		ModelAndView mv=null;
		if(uname.equals("dhanya") && pwd.equals("1212"))
			mv = new ModelAndView("welcome");
		else
		{
			mv = new ModelAndView("login");
		}
			return mv;
	}
	
	@RequestMapping("/doLogin")
	public ModelAndView sayHello()
	{
		ModelAndView mv= new ModelAndView("login");
		return mv;
	}

}
