package com.gzd.service;

/**
 * Created by gzd on 2017/5/14.
 */
public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao){
        this.userDao=userDao;
    }

    public void addServ(){
        System.out.println("我是service的业务逻辑");
        userDao.add();
    }

}
