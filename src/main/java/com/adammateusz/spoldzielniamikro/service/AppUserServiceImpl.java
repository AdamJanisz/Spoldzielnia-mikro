package com.adammateusz.spoldzielniamikro.service;

import com.adammateusz.spoldzielniamikro.dao.AppUserRepository;
import com.adammateusz.spoldzielniamikro.domain.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service(value="appUserService")
public class AppUserServiceImpl implements AppUserService, UserDetailsService {

	@Autowired
	AppUserRepository appUserRepository;


	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		AppUser user = appUserRepository.findByUsername(userId);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	@Transactional
	public AppUser createAppUser(AppUser appUser) {
		 return appUserRepository.save(appUser);
	}

	@Transactional
	public void editAppUser(long id,AppUser appUser) {

		AppUser user = appUserRepository.findById(id);
		user.setFirstName(appUser.getFirstName());
		user.setLastName(appUser.getLastName());
		user.setEmail(appUser.getEmail());
		user.setUsername(appUser.getUsername());
		user.setPassword(appUser.getPassword());
        appUserRepository.save(user);
	}



	@Transactional
	public List<AppUser> listAppUser() {
		return appUserRepository.findAll();
	}

	@Transactional
	public void removeAppUser(Long id) {
        appUserRepository.deleteById(id);
	}

	@Transactional
	public AppUser getAppUser(long id) {
		return appUserRepository.findById(id);
	}

	@Transactional
	public AppUser findByLogin(String username) {
		return appUserRepository.findByUsername(username);
	}



}


