package com.stefanomaglione.youart.service;

import com.stefanomaglione.youart.model.Customer;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CustomerService extends UserDetailsService{
	Customer createCustomer(Customer customer);
	Customer getCustomer(String email);
	Customer getCustomerByCustomerId(String customerId);
	//Customer updateUser(String userId, UserDto user);
	//void deleteUser(String userId);
	//List<Customer> getUsers(int page, int limit);
	/*boolean verifyEmailToken(String token);
	boolean requestPasswordReset(String email);
	boolean resetPassword(String token, String password);*/
}
