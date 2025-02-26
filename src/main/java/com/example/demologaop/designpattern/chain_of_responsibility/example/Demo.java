package com.example.demologaop.designpattern.chain_of_responsibility.example;

import com.example.demologaop.designpattern.chain_of_responsibility.example.middleware.Middleware;
import com.example.demologaop.designpattern.chain_of_responsibility.example.middleware.RoleCheckMiddleware;
import com.example.demologaop.designpattern.chain_of_responsibility.example.middleware.ThrottlingMiddleware;
import com.example.demologaop.designpattern.chain_of_responsibility.example.middleware.UserExistsMiddleware;
import com.example.demologaop.designpattern.chain_of_responsibility.example.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private static void init() {
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        // 构建责任链：所有检查器以链式结构连接
        Middleware middleware = Middleware.link(
                new ThrottlingMiddleware(2),
                new UserExistsMiddleware(server),
                new RoleCheckMiddleware()
        );
        // 设置构建的责任链
        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {
        init();

        boolean success = false;
        do {
            System.out.print("Enter email: ");
            String email = reader.readLine();
            System.out.print("Input password: ");
            String password = reader.readLine();
            success = server.logIn(email, password);

        } while (!success);
    }
}
