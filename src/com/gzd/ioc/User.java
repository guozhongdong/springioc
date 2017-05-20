package com.gzd.ioc;

public class User {


	private String name;

   /* public User(String name){
        this.name=name;
    }*/
	public void setName(String name){
		this.name = name;
	}
	public void add (){

	    System.out.println("add .........");
	    System.out.println("----name is "+name);
	}


}
