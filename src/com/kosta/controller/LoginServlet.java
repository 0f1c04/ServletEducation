package com.kosta.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginChk.kosta")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost..........");
        response.setContentType("text/html;charset=utf-8");

        String uid = request.getParameter("userid");
        String upw = request.getParameter("userpw");

        System.out.println("uid=" + uid);
        System.out.println("upw=" + upw);

        PrintWriter out = response.getWriter();
        out.append(String.format("<h1>아이디는 %s</hr>", uid));
        out.append(String.format("<h1>비밀번호는! %s</hr>", upw));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
