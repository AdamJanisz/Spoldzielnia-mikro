package com.adammateusz.spoldzielniamikro.utils;

import com.adammateusz.spoldzielniamikro.domain.AppUserRole;
import com.adammateusz.spoldzielniamikro.service.AppUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


import java.util.HashSet;
import java.util.Set;

public class AppUserRoleConverter implements Converter<String, Set<AppUserRole>> {

	@Autowired
	AppUserRoleService appUserRoleService;
	
	@Override
	public Set<AppUserRole> convert(String source) {
		
		Set<AppUserRole> userRoleList = new HashSet<AppUserRole>(0);
		
			userRoleList.add(appUserRoleService.getAppUserRole(Integer.parseInt(source)));
		
		return userRoleList;
	}
}


