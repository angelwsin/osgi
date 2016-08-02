package com.google.guice.dao.impl;

import com.google.guice.dao.UserProviderDao;
import com.google.guice.modle.User;

public class UserProviderDaoImpl implements UserProviderDao{

    public void save(User user) {
        
        System.out.println(" userProviderDao save "+user.getUserName());
    }

}
