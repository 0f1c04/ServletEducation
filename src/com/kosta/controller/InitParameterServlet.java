package com.kosta.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {
                "/InitParameterServlet",
                "/param1",
                "/param2"
        },
        initParams = {
                @WebInitParam(name = "email", value = "test@test.com"),
                @WebInitParam(name = "phone", value = "010-111-1111")
        },
        loadOnStartup = 1 // 우선순위
)
public class InitParameterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(getInitParameter("email"));
        System.out.println(getInitParameter("phone"));
    }
}
