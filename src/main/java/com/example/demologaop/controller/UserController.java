package com.example.demologaop.controller;

import com.example.demologaop.annotation.MyAnnotation;

public class UserController {
   @MyAnnotation(name="张三",age=18,hobby = {"跑步","篮球"})
    public String get(){
        return "hello Annotation!";
    }

}
