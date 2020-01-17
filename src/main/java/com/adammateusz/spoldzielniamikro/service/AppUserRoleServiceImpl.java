package com.adammateusz.spoldzielniamikro.service;

import com.adammateusz.spoldzielniamikro.dao.AppUserRoleRepository;
import com.adammateusz.spoldzielniamikro.domain.AppUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AppUserRoleServiceImpl implements AppUserRoleService {

    @Autowired
    AppUserRoleRepository appUserRoleRepository;

    @Transactional
    public void addAppUserRole(AppUserRole appUserRole) {
        appUserRoleRepository.save(appUserRole);
    }

    @Override
    public AppUserRole findByRole(String role) {
        return appUserRoleRepository.findByRole(role);
    }

    @Transactional
    public List<AppUserRole> listAppUserRole() {
        return appUserRoleRepository.findAll();
    }

    @Transactional
    public AppUserRole getAppUserRole(long id) {
        return appUserRoleRepository.getOne(id);
    }
}

