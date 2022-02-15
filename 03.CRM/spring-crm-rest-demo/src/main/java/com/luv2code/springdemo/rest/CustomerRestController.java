package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// autowire customer service
	@Autowired
	private CustomerService customerService;

	// add mapping GET
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}

	// get only one customer

	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		
		Customer thCustomer=customerService.getCustomer(customerId);
		
		if(thCustomer==null) {
			throw new CustomerNotFoundException("customer id not found- "+customerId);
			
		}
		return thCustomer;

	}
	
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		theCustomer.setId(0);
		
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer thCustomer) {
		customerService.saveCustomer(thCustomer);
		return thCustomer;
	}
	
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Customer tempCustomer = customerService.getCustomer(customerId);
		
		if(tempCustomer== null)
		{
			throw new CustomerNotFoundException("Customer "+customerId+" not found");
		}
		
		customerService.deleteCustomer(customerId);
		return "Deleted customer i- "+customerId;
	}

}
