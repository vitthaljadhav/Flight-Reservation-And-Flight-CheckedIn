package com.vitthal.flightreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vitthal.flightreservation.entities.User;
import com.vitthal.flightreservation.repos.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("User Not Fount for email " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				user.getRoles());
	}
}
