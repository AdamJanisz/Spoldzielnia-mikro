//package com.auth.auth.service.impl;
//
//import com.auth.auth.dao.UserDao;
//import com.auth.auth.model.AppUser;
//import com.auth.auth.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.List;
//
//
//@Service(value = "userService")
//public class UserServiceImpl implements UserDetailsService {
//
//	@Autowired
//	private UserDao userDao;
//
//	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
//		AppUser user = userDao.findByUsername(userId);
//		if(user == null){
//			throw new UsernameNotFoundException("Invalid username or password.");
//		}
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
//	}
//
//	private List<SimpleGrantedAuthority> getAuthority() {
//		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
//	}
//}
