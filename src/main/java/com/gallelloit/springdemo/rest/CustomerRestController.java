package com.gallelloit.springdemo.rest;

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

import com.gallelloit.springdemo.entity.Customer;
import com.gallelloit.springdemo.service.CustomerService;

/**
 * 
 * Customer tracker main REST controller.
 * 
 * @RestController gives support for Serialize/deserialize accepted and returned objects. The Controller
 * has REST support for:
 * 
 * C - CREATE:
 * 		Http.post	=> 	addCustomer(@RequestBody Customer theCustomer)
 * R - READ
 * 		Http.get	=>	getCustomers()
 * 		Http.get	=>	getCustomer(int)
 * U - UPDATE:
 * 		Http.put	=>	updateCustomer(@RequestBody Customer theCustomer)
 * D - DELETE:
 * 		Http.delete	=>	deleteCustomer(@PathVariable int customerId)
 * 
 * Exception handling is performed using customized exception objects.
 * 
 * @author pgallello
 *
 */
@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		
		return customerService.getCustomers();
		
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		
		Customer theCustomer = customerService.getCustomer(customerId);
		
		if (theCustomer == null) {
			throw new CustomerNotFoundException("Customer not found - " + customerId);
		}
		
		return customerService.getCustomer(customerId);
		
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		// Force an addition
		theCustomer.setId(0);
		
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
		
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
		
	}

	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		// Check if the customer exists
		Customer theCustomer = customerService.getCustomer(customerId);
		
		if (theCustomer == null) {
			throw new CustomerNotFoundException("Customer not found: " + customerId);
		}
		
		customerService.deleteCustomer(customerId);
		
		return "Deleted customer id=" + customerId;
		
	}
	
}
