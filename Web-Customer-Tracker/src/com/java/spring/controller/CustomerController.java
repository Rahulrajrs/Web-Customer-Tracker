package com.java.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.spring.entity.Customer;
import com.java.spring.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	/*//need to inject the customer dao
	@Autowired
	private CustomerDAO customerDAO;*/
	//need to inject customeservice
	
	@Autowired
	private CustomerService customerService;
	
	//@RequestMapping("/list")
	
	//@PostMapping("/list")
	@GetMapping("/list")
	public String listCustomers(Model model){
		
		//get the customer from the dao
		List<Customer> theCustomers=customerService.getCustomers();
		
		//add the customer to the model
		
		model.addAttribute("customers",theCustomers);
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		
		//create a model attribute to bind data
		
		Customer theCustomer=new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
		
		//save the customer using our service
		
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
							Model theModel){
		
		//get the customer from the database
		
		Customer theCustomer=customerService.getCustomer(theId);
		
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId){
		
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}

}
