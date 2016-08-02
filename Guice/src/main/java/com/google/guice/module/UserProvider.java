package com.google.guice.module;

import com.google.guice.dao.UserDao;
import com.google.guice.provider.UserDaoProvider;
import com.google.inject.AbstractModule;

public class UserProvider extends AbstractModule{

    @Override
    protected void configure() {
        
        bind(UserDao.class).toProvider(UserDaoProvider.class);
    }

}
