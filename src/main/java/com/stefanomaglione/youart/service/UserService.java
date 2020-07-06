package com.stefanomaglione.youart.service;

import com.stefanomaglione.youart.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
	User createUser(User user);
	User getUser(String email);
	User getUserByUserId(String customerId);
}
