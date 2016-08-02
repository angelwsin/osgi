package com.google.guice.dao.impl;

import com.google.guice.dao.UserDao;
import com.google.guice.modle.Teacher;
import com.google.guice.modle.User;

public class TeacherDaoImpl implements UserDao{

    public void save(User user) {
        if(user instanceof Teacher){
            Teacher t = (Teacher) user;
            System.out.println(" save teacher " + t.getUserName()); 
        }
        
    }

}
