package com.google.guice.dao;

import com.google.guice.modle.User;
import com.google.guice.provider.UserDaoProvider;
import com.google.inject.ProvidedBy;


@ProvidedBy(UserDaoProvider.class)
public interface UserDao {
    
    public void save(User user);

}
