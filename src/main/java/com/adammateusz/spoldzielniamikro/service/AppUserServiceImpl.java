package com.adammateusz.spoldzielniamikro.service;

import com.adammateusz.spoldzielniamikro.dao.AppUserRepository;
import com.adammateusz.spoldzielniamikro.domain.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	AppUserRepository appUserRepository;


	@Transactional
	public void addAppUser(AppUser appUser) {

		appUserRepository.save(appUser);
	}

	@Transactional
	public void editAppUser(AppUser appUser) {
		//appUser.getAppUserRole().add(appUserRoleRepository.findByRole("ROLE_USER"));
        appUserRepository.save(appUser);
	}



	@Transactional
	public List<AppUser> listAppUser() {
		return appUserRepository.findAll();
	}

	@Transactional
	public void removeAppUser(AppUser appUser) {
        appUserRepository.delete(appUser);
	}

	@Transactional
	public AppUser getAppUser(long id) {
		return appUserRepository.findById(id);
	}

	@Transactional
	public AppUser findByLogin(String login) {
		return appUserRepository.findByLogin(login);
	}



}


