package com.gzd.jdbc.service;

import com.gzd.jdbc.dao.UserDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gzd on 2017/5/21.
 */
@Transactional
public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addService(){

        System.out.println("service....");
        userDao.add();
    }

    public void buy(){

        userDao.addSalary();
        int a = 10/0;   //出现异常 ，事务回滚
        userDao.delSalary();
        //System.out.println("service....");
       // userDao.add();
    }
}
