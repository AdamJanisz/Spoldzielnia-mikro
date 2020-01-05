package com.auth.auth.service;



import com.auth.auth.model.AppUser;

import java.util.List;

public interface UserService {

    AppUser save(AppUser user);
    List<AppUser> findAll();
    AppUser findOne(long id);
    void delete(long id);
}
