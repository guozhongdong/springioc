package com.gzd.ioc;

import com.gzd.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	@Test
	public void getUser(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserService u = (UserService) context.getBean("userService");
		/*User user= new User();
		ServletCon
		user.add();
		System.out.println(user);*/
        //u.add();
        u.addServ();

		System.out.println(u);
	}
}
