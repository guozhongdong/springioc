package com.gzd.anno;

import org.springframework.stereotype.Component;

/**
 * Created by gzd on 2017/5/20.
 */
@Component(value="userdao")
public class UserDao {

    public void add(){
        System.out.println("dao ..........");
    }
}
