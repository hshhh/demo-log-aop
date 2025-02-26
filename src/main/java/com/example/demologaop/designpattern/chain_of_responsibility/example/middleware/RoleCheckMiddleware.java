package com.example.demologaop.designpattern.chain_of_responsibility.example.middleware;

/**
 * 检查用户角色
 */
public class RoleCheckMiddleware extends Middleware{
    @Override
    public boolean check(String email, String password) {
        if ("admin@example.com".equals(email)) {
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");
        return checkNext(email, password);
    }
}
