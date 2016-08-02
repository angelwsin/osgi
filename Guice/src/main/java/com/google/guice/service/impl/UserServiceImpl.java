package com.google.guice.service.impl;

import com.google.guice.dao.UserDao;
import com.google.guice.modle.User;
import com.google.guice.service.UserService;
import com.google.inject.Inject;

public class UserServiceImpl implements UserService{
    
    private UserDao userDao;
    
    @Inject
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    

    public void save(User user) {
        userDao.save(user);
    }

}
