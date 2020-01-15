package com.adammateusz.spoldzielniamikro.service;



import com.adammateusz.spoldzielniamikro.domain.AppUser;

import java.util.List;

public interface AppUserService {

	public AppUser createAppUser(AppUser appUser);
	public void editAppUser(long id,AppUser user);
	public List<AppUser> listAppUser();
	public void removeAppUser(Long id);
	public AppUser getAppUser(long id);
    public AppUser findByLogin(String login);
	AppUser findLoggedAppUser();
	AppUser findLoggedAppUser(Object principal);

}
