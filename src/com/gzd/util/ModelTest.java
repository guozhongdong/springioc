package com.gzd.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by gzd on 2017/5/28.
 */
public class ModelTest {

    /*@Test
    public void test(){
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        *//*for (String list:a){
            if("2".equals(list)){
                a.remove(list);
            }
        }*//*
        Iterator<String> it = a.iterator();
        while(it.hasNext()){
            if("2".equals(it.next())){
                it.remove();
            }
        }
        System.out.println(a);
    }*/

    public static void main(String args[]){

        Test1 t = new Test1();
        t.a++;
        System.out.println("外部类"+t.a);
        Test2 t2 = new Test2();


    }

    static class Test2{
        public static  void main(String args[]){
            Test1 t = new Test1();
            System.out.println("内部类"+t.a);
        }
    }

}
