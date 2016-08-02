package com.google.guice.module;

import com.google.guice.dao.UserDao;
import com.google.guice.dao.impl.TeacherDaoImpl;
import com.google.guice.dao.impl.UserDaoImpl;
import com.google.guice.modle.annotation.TeacherDao;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class TeacherModule extends AbstractModule{

    @Override
    protected void configure() {
        
        /**
         * 对于一个接口有多种实现的时候，链式绑定就不好区分该用哪种实现了。
         * 可以把Annotations绑定方式看作是链式绑定的一种扩展，专门用来解决这种同一个接口有多种实现的问题。
         * Annotations绑定又可以分为两种，一种是需要自己写Annotations
         * 另外一种则使用@Named的方式
         */
        //自定义注解
        bind(UserDao.class).annotatedWith(TeacherDao.class).to(TeacherDaoImpl.class);
        //实例绑定
       // .toInstance(new TeacherDaoImpl());
        //使用@Named的方式
        bind(UserDao.class).annotatedWith(Names.named("userDao")).to(UserDaoImpl.class);
        
    }

}
