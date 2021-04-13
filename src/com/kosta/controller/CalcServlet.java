package com.kosta.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculator")
public class CalcServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String su1 = request.getParameter("num1");
        String op = request.getParameter("op");
        String su2 = request.getParameter("num2");

        int num1 = Integer.parseInt(su1);
        int num2 = Integer.parseInt(su2);
        int result = 0;

        switch (op) {
            case "+": result = num1 + num2; break;
            case "-": result = num1 - num2; break;
            case "*": result = num1 * num2; break;
            case "/": result = num1 / num2; break;
            default: break;
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<h3>결과는 " + result);
    }
}
