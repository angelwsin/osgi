package com.google.guice.provider;

import com.google.guice.dao.UserDao;
import com.google.guice.dao.impl.UserDaoImpl;
import com.google.inject.Provider;

public class UserDaoProvider implements Provider<UserDao>{

    
    
    public UserDao get() {
        return new UserDaoImpl();
    }

}
