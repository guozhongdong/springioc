package com.gzd.anno;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by gzd on 2017/5/20.
 * 使用注解创建对象
 */

@Controller
public class UserService {

    //@Autowired  //spring 2.5以后自带的注解
    @Resource     // jdk支持注解
    private UserDao userDao;

    /**
     * @author gzd
     * <br>差不多这是一个注释</br>
     * */
    public void add(){
        System.out.println("service233231...........");
        userDao.add();
        //
        // UserService.class
        //getClass(UserService);
    }
}
