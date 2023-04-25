package com.example.demologaop.controller;

import com.example.demologaop.annotation.MyAnnotation;

public class UserController {
    /**
     * 使用注解@MyAnnotation
     * @return
     */
   @MyAnnotation(name="张三",age=18,hobby = {"跑步","篮球"})
    public String get(){
        return "hello Annotation!";
    }

}
