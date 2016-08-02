package com.google.guice.service.impl;

import com.google.guice.dao.UserDao;
import com.google.guice.modle.User;
import com.google.guice.modle.annotation.TeacherDao;
import com.google.guice.service.TeacherService;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class TeacherUserviceImpl implements TeacherService{
    
    private UserDao teacherDao;
    private UserDao userDao;
    
    @Inject
    public TeacherUserviceImpl(@TeacherDao UserDao teacherDao,@Named("userDao")UserDao userDao) {
        this.teacherDao = teacherDao;
        this.userDao = userDao;
    }

    public void save(User user) {
        teacherDao.save(user);
        userDao.save(user);
    }

}
