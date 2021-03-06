package com.adammateusz.spoldzielniamikro.service;

import com.adammateusz.spoldzielniamikro.dao.AppUserRepository;

import com.adammateusz.spoldzielniamikro.dao.ApartmentRepository;
import com.adammateusz.spoldzielniamikro.domain.Apartment;

import com.adammateusz.spoldzielniamikro.dao.AppUserRoleRepository;
import com.adammateusz.spoldzielniamikro.domain.AppUser;
import com.adammateusz.spoldzielniamikro.domain.AppUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service(value="appUserService")
public class AppUserServiceImpl implements AppUserService, UserDetailsService {

	@Autowired
	AppUserRepository appUserRepository;
	@Autowired
	ApartmentRepository apartmentRepository;

	@Autowired
	AppUserRoleRepository appUserRoleRepository;


	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		AppUser user = appUserRepository.findByUsername(userId);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
	}

	private List<SimpleGrantedAuthority> getAuthority(AppUser app) {
		Set<AppUserRole> roleSet = app.getAppUserRole();
		List<AppUserRole> rooleList = new ArrayList<>();
		for (AppUserRole role : roleSet)
			rooleList.add(role);

		List<SimpleGrantedAuthority> userRoles = new ArrayList<>();
		for (AppUserRole role : rooleList)
			userRoles.add(new SimpleGrantedAuthority(role.getRole()));


		return userRoles;
	}

	@Transactional
	public AppUser createAppUser(AppUser appUser) {

		apartmentRepository.saveAndFlush(appUser.getApartment());
		appUser.getAppUserRole().add(appUserRoleRepository.findByRole("ROLE_USER"));//set role user by default
		//appUser.getAppUserRole().add(appUserRoleRepository.findByRole("ROLE_ADMIN")); can be user and admin as well
		return appUserRepository.save(appUser);
	}

	@Transactional
	public List<AppUser> findByAparmentId(long aparmentId) {
		return appUserRepository.appUsersForAparment(aparmentId);
	}

	@Transactional
	public void editAppUser(long id, AppUser appUser) {

		AppUser user = appUserRepository.findById(id);
		user.setFirstName(appUser.getFirstName());
		user.setLastName(appUser.getLastName());
		user.setEmail(appUser.getEmail());
		user.setUsername(appUser.getUsername());
		user.setPassword(appUser.getPassword());
		user.setAppUserRole(appUser.getAppUserRole());
		user.setApartment(appUser.getApartment());
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

	@Override
	public AppUser findLoggedAppUser() {

			String username;
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			if (principal instanceof UserDetails) {
				username = ((UserDetails) principal).getUsername();
			} else {
				username = principal.toString();
			}



			AppUser appUser = this.findByLogin(username);
			return appUser;

	}

	@Override
	public AppUser findLoggedAppUser(Object principal) {

		String username;
		principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}



		AppUser appUser = this.findByLogin(username);
		return appUser;

	}
}

