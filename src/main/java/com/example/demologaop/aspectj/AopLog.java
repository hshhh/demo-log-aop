package com.example.demologaop.aspectj;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.json.JSONUtil;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Aspect
@Component
@Slf4j
public class AopLog {
    /**
     * 切入点 Pointcut
     * 切入点是指我们要对哪些 Joinpoint 进行拦截的定义(被代理对象加强的方法)
     *
     * 连接点（JoinPoint） : 连接点是指那些被拦截到的点。在spring中,这些点指的是方法,因为spring只支持方法类型的连接点(被代理对象的所有方法)
     */
    @Pointcut("execution(public * com.example.demologaop.controller.*Controller.*(..))")
    public void log(){
        log.info("pointCut签名");
    }

    //环绕通知
    @Around("log()")
    public Object aroundAdvice(ProceedingJoinPoint point){
        //从RequestContextHolder中获取request对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        long startTime = System.currentTimeMillis();
        try {
            Object[] args = point.getArgs();//获得方法执行所需的参数
            log.info("通知类中的aroundAdvice方法执行了。。【前置通知】");
            Object result = point.proceed(args); //明确调用切入点方法(切入点方法)
            log.info("通知类中的aroundAdvice方法执行了。。【返回通知】");
            log.info("【返回通知】");
            String header = request.getHeader("User-Agent");
            //获取用户代理对象
            UserAgent userAgent = UserAgent.parseUserAgentString(header);
            if(args!=null){
                for(Object ob:args){
                    if(ob instanceof Map){
                        Map<String,Object> mp = (Map<String, Object>) ob;
                        log.info(JSONUtil.toJsonStr(mp));
                    }
                }
            }


            final Log l = Log.builder()
                    .threadId(Long.toString(Thread.currentThread().getId()))
                    .threadName(Thread.currentThread().getName())
                    .ip(getIp(request))
                    .url(request.getRequestURI())
                    .classMethod(String.format("%s.%s",point.getSignature().getDeclaringTypeName(),point.getSignature().getName()))
                    .httpMethod(request.getMethod())
                    .requestParams(getNameAndValue(point))
                    .result(result)
                    .timeCost(System.currentTimeMillis()-startTime)
                    .userAgent(header)
                    .browser(userAgent.getBrowser().toString())
                    .os(userAgent.getOperatingSystem().toString())
                    .build();
            log.info("Request Log Info:{}", JSONUtil.toJsonStr(l));

            return result;
        } catch (Throwable e) {
            log.info("通知类中的aroundAdvice方法执行了。。【异常通知】");
            throw new RuntimeException(e);
        } finally {
            log.info("通知类中的aroundAdvice方法执行了。。【后置通知】");

        }


    }

    /**
     * 获取方法参数名和参数值
     * @param point
     * @return
     */
    private Map<String,Object> getNameAndValue(ProceedingJoinPoint point){
        final Signature signature = point.getSignature();
        //转换为methodSignature对象，获取参数名称
        MethodSignature methodSignature = (MethodSignature) signature;
        final  String[] names = methodSignature.getParameterNames();
        final  Object[]  args = point.getArgs();
        if(ArrayUtil.isEmpty(names)||ArrayUtil.isEmpty(args)){
            return Collections.emptyMap();
        }
        if(names.length!=args.length){
            //获取方法名
            log.warn("{}方法参数名和参数值数量不一致",methodSignature.getName());
            return Collections.emptyMap();
        }
        Map<String,Object> mp = new HashMap<>();
        for(int i=0;i<names.length;i++){
            mp.put(names[i],args[i]);
        }
        return mp;
    }


    private static final String UNKNOWN =" unknown";
    /**
     *  获取ip地址
     */
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        String comma = ",";
        String localhost = "127.0.0.1";
        if (ip.contains(comma)) {
            ip = ip.split(",")[0];
        }
        if (localhost.equals(ip)) {
            // 获取本机真正的ip地址
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                log.error(e.getMessage(), e);
            }
        }
        return ip;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    static class Log{
        /**
         * 线程id
         */
        private String threadId;
        //线程名称
        private String threadName;
        //ip
        private String ip;
        //url
        private String url;
        //http方法 get post put delete patch
        private String httpMethod;
        //类方法
        private String classMethod;
        //请求参数
        private Object requestParams;
        //返回参数
        private Object result;
        //接口耗时
        private Long timeCost;
        //操作系统
        private String os;
        //浏览器
        private String browser;
        //user-agent
        private String userAgent;




    }

}
