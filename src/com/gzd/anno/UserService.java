package com.gzd.anno;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by gzd on 2017/5/20.
 * 使用注解创建对象
 */
@Repository(value="userService")
public class UserService {

    //@Autowired  //spring 2.5以后自带的注解
    @Resource     // jdk支持注解
    private UserDao userDao;

    public void add(){
        System.out.println("service...........");
        userDao.add();
    }
}
