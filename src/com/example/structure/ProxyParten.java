package com.example.structure;

/**
 * @description: 代理模式
 * @program: ProxyParten
 * @Date: 2020/11/8 10:56
 * @Author: benjamin.wang
 * @Copyright（C）: 2014-2019 X-Financial Inc. All rights reserved.
 * 注意：本内容仅限于小赢科技有限责任公司内部传阅，禁止外泄以及用于其他的商业目的。
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 1. 接口集成模式
 */
interface IUser {
    boolean login(String name);
}
class User implements IUser {
    @Override
    public boolean login(String name) {
        System.out.println("login process ...");
        return true;
    }
}
class UserProxy implements IUser {
    private User user;

    public UserProxy() {
        this.user = new User();
    }

    @Override
    public boolean login(String name) {
        System.out.println(name+" login ...");
        user.login(name);
        System.out.println(name+" login success");
        return true;
    }
}

/**
 * 2.UserProxy可以直接继承User实现代理增强
 */

/**
 * 3。动态代理
 */
class DynamicProxyHandler implements InvocationHandler {
    private Object obj;

    public DynamicProxyHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始");
        Object res = method.invoke(obj, args);
        System.out.println("结束");
        return res;
    }
}
public class ProxyParten {
    public static void main(String[] args) {
//        UserProxy proxy = new UserProxy();
//        proxy.login("tom");

        DynamicProxyHandler handler = new DynamicProxyHandler(new User());
        IUser iUser = (IUser) Proxy.newProxyInstance(User.class.getClassLoader(), new Class[]{IUser.class}, handler);
        iUser.login("jerry");
    }
}
