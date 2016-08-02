package com.google.guice.module;

import com.google.guice.dao.UserDao;
import com.google.guice.dao.impl.UserDaoImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

/**
 * 链式绑定
 * 链式绑定针对于同样的类型都绑定到同一种目标类型时，非常好用，但是对于一个接口有多种实现的时候，链式绑定就不好区分该用哪种实现了。
 * 可以把Annotations绑定方式看作是链式绑定的一种扩展，专门用来解决这种同一个接口有多种实现的问题。
 * Annotations绑定又可以分为两种，一种是需要自己写Annotations，另外一种则简化了一些。
 * 
 * @author wb-wq209038
 * @version $Id: UserModule.java, v 0.1 2016年8月2日 下午1:11:47 wb-wq209038 Exp $
 */
public class UserModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(UserDao.class).to(UserDaoImpl.class).in(Scopes.SINGLETON);
        
    }

}
