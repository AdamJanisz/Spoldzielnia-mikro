package com.adammateusz.spoldzielniamikro.service;



import com.adammateusz.spoldzielniamikro.domain.AppUserRole;

import java.util.List;
import java.util.Set;

public interface AppUserRoleService {

    void addAppUserRole(AppUserRole appUserRole);
    AppUserRole findByRole(String role);

    List<AppUserRole> listAppUserRole();

    AppUserRole getAppUserRole(long id);

}
