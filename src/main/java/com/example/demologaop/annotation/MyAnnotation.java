package com.example.demologaop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * 自定义注解有以下格式
 *
 * public @interface 注解名称 {
 *     属性列表
 * }
 *
 *
 * 对于自定义的注解 @MyAnnotation被限定只能使用在type(类、接口)或METHOD(方法上)
 * 元注解@Target是专门用来修饰某个自定义注解能够被应用在哪些java元素上面
 *
 * 元注解@Retention，用来修饰自定义注解的生命力 (retention：保留，保持)
 * 被定义为RetentionPolicy.SOURCE，那么这个注解将被限定在java源文件中，不会参与
 * 编译也不会在运行期间起任何作用，相当于注释
 *
 * 被定义为RetentionPolicy.CLASS，则它会被编译到class文件中，那么编译器可以在编译时
 * 根据注解做一些动作，但是运行时JVM(java虚拟机)会忽略它，我们在运行期间也不能
 * 读取到，是默认的
 *
 * 被定义为RetentionPolicy.RUNTIME，那么这个注解可以在运行期间的加载阶段被加载到class
 * 对象中。那么在程序运行阶段，我们可以通过反射得到这个注解，并判断是否有这个注解或者这个注解
 * 属性的值，从而执行不同的程序代码段。实际开发中一般用它。
 *
 */
@Target(value={ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    public String name();
    int age();
    String sex() default "女";
    String[] hobby();
}
