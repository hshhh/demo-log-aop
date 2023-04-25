package com.example.demologaop.test;


import com.example.demologaop.annotation.MyAnnotation;
import com.fasterxml.jackson.databind.introspect.Annotated;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Test {
    /**
     * 利用反射获取注解及信息
     * @param args
     */
    public static void main(String[] args){

        try {
            //获取class对象
            Class myClass = Class.forName("com.example.demologaop.controller.UserController");
            //获取该对象身上所有的注解
            Annotation[] annotations = myClass.getAnnotations();
            System.out.println(annotations.toString());
            //获取里面的一个方法
            Method method = myClass.getMethod("get");
            //判断该元素上是否配置有某个特定的注解
            if(method.isAnnotationPresent(MyAnnotation.class)){
                System.out.println("get方法上配置了MyAnnotation注解");
                //获取该元素上指定类型的注解
                MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
                System.out.println("name: "+myAnnotation.name()
                + " age: "+myAnnotation.age() + " sex: "+myAnnotation.sex()
                + " hobby: " + myAnnotation.hobby()[0]
                );
            }else{
                System.out.println("UserController类的get方法上没有配置MyAnnotation注解！");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }

}
