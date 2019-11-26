package com.adammateusz.spoldzielniamikro.service;



import com.adammateusz.spoldzielniamikro.domain.AppUser;

import java.util.List;

public interface AppUserService {

	public void addAppUser(AppUser user);
	public void editAppUser(AppUser user);
	public List<AppUser> listAppUser();
	public void removeAppUser(AppUser appUser);
	public AppUser getAppUser(long id);
    public AppUser findByLogin(String login);

}
