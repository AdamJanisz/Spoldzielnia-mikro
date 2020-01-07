package com.adammateusz.spoldzielniamikro.service;

import com.adammateusz.spoldzielniamikro.dao.AppUserRepository;
import com.adammateusz.spoldzielniamikro.dao.ApartmentRepository;
import com.adammateusz.spoldzielniamikro.domain.Apartment;
import com.adammateusz.spoldzielniamikro.domain.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	AppUserRepository appUserRepository;
	@Autowired
	ApartmentRepository apartmentRepository;


	@Transactional
	public AppUser createAppUser(AppUser appUser) {
		apartmentRepository.saveAndFlush(appUser.getApartment());
		return appUserRepository.save(appUser);
	}

	@Transactional
	public void editAppUser(long id,AppUser appUser) {


		AppUser user = appUserRepository.findById(id);
		user.setFirstName(appUser.getFirstName());
		user.setLastName(appUser.getLastName());
		user.setEmail(appUser.getEmail());
		user.setLogin(appUser.getLogin());
		user.setPassword(appUser.getPassword());
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
	public AppUser findByLogin(String login) {
		return appUserRepository.findByLogin(login);
	}



}


