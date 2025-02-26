package com.example.demologaop.designpattern.chain_of_responsibility.example.middleware;

import com.example.demologaop.designpattern.chain_of_responsibility.example.server.Server;

/**
 * 检查用户登陆信息
 */
public class UserExistsMiddleware extends Middleware{

    private final Server server;

    public UserExistsMiddleware(Server server) {
        this.server = server;
    }

    @Override
    public boolean check(String email, String password) {
        if (!server.hasEmail(email)) {
            System.out.println("邮箱未注册！");
            return false;
        }
        if (!server.isValidPassword(email, password)) {
            System.out.println("错误的密码！");
            return false;
        }
        return checkNext(email, password);
    }
}
