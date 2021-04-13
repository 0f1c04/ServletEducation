package com.kosta.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet({"/first3", "/first4"})
public class FirstServlet extends javax.servlet.http.HttpServlet {
    //초기화
    public void init(ServletConfig config) throws ServletException {
        System.out.println("FirstServlet init");
    }

    //소멸
    public void destroy() {
        System.out.println("FirstServlet destroy");
    }

    //get방식 요청
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FirstServlet doGet요청");
        response.getWriter().append("Get Served at: ").append(request.getContextPath());
    }

    //post방식 요청
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FirstServlet doPost요청");
        response.getWriter().append("Post Served at: ").append(request.getContextPath());
        //doGet(request, response);
    }

}
