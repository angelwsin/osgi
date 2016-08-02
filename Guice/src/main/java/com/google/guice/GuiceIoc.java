package com.google.guice;

import com.google.guice.modle.Teacher;
import com.google.guice.modle.User;
import com.google.guice.module.TeacherModule;
import com.google.guice.module.UserModule;
import com.google.guice.module.UserProvider;
import com.google.guice.provider.UserDaoProvider;
import com.google.guice.service.TeacherService;
import com.google.guice.service.UserProviderService;
import com.google.guice.service.UserService;
import com.google.guice.service.impl.TeacherUserviceImpl;
import com.google.guice.service.impl.UserProviderServiceImpl;
import com.google.guice.service.impl.UserServiceImpl;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceIoc {

    //在Guice中需要定义Module来进行关联
    public static void main(String[] args) {
        
        //链式绑定
        Injector injector =  Guice.createInjector(new UserModule());
        
       UserService userService =  injector.getInstance(UserServiceImpl.class);
       
       User user = new User();
       user.setUserName("Guice");
       
       userService.save(user);
       //一种是需要自己写Annotations另外一种则使用@Named的方式
       Teacher t = new Teacher();
       t.setUserName(" Mr Wu ");
       Injector injectorT =  Guice.createInjector(new TeacherModule());
        TeacherService tService =  injectorT.getInstance(TeacherUserviceImpl.class);
        tService.save(t);
        //Provider绑定
        Injector in =   Guice.createInjector(new UserProvider());
        UserService s = in.getInstance(UserServiceImpl.class);
        s.save(user);
        //如果想自动注入（不使用Module手动关联）服务的话，可以使用@ProviderBy注解
       UserProviderService proService =  Guice.createInjector().getInstance(UserProviderServiceImpl.class);
       proService.save(user);
        
    }
}
