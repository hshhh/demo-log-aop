package com.example.demologaop.designpattern.chain_of_responsibility.example.middleware;

/**
 * 检查请求数量限制
 */
public class ThrottlingMiddleware extends Middleware{
    // 每分钟最多请求次数
    private final int requestPerMinute;
    // 请求计数器
    private int request;
    // 当前时间
    private long currentTime;

    public ThrottlingMiddleware(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }


    @Override
    public boolean check(String email, String password) {
        // 如果超过1分钟，重置request，currentTime
        if (System.currentTimeMillis() > currentTime + 60_000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }
        // 请求计数器+1
        request++;

        if (request > requestPerMinute) {
            System.out.println("超出请求最大次数，请稍候再试，当前请求次数 = " + request);
            // 阻断请求传递
            return false;
            //Thread.currentThread().interrupt();
        }
        // 调用责任链的下一个对象的check()方法
        return checkNext(email, password);
    }


}
