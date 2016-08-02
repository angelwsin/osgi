package com.google.guice.service.impl;

import com.google.guice.dao.UserDao;
import com.google.guice.modle.User;
import com.google.guice.service.UserProviderService;
import com.google.inject.Inject;


public class UserProviderServiceImpl implements UserProviderService{
    
    @Inject
    private UserDao userDao;

    public void save(User user) {
        userDao.save(user);
    }

}
