package com.google.guice.dao.impl;

import com.google.guice.dao.UserDao;
import com.google.guice.modle.User;

public class UserDaoImpl implements UserDao{

    public void save(User user) {
        
        System.out.println(" save User "+ user.getUserName());
    }

}
