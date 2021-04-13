package com.kosta.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

@WebServlet("/memberInsert")
public class MemberServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();


        // 파라미터값이 많은 경우 더 유용
        Enumeration<String> names = request.getParameterNames();
        while(names.hasMoreElements()) {
            String parmName = names.nextElement();
            String[] paramValues = request.getParameterValues(parmName);
            for(String val:paramValues) {
                out.println("<h3>" + parmName + "-->" + val + "</h3>");
            }
        }
        //        String name = request.getParameter("name");
//        String phonenumber = request.getParameter("phonenumber");
//        String id = request.getParameter("id");
//        String passwd = request.getParameter("passwd");
//        String[] subject = request.getParameterValues("subject");
//
//        System.out.println(name);
//        System.out.println(phonenumber);
//        System.out.println(id);
//        System.out.println(passwd);
//        System.out.println(Arrays.toString(subject));
    }

}
