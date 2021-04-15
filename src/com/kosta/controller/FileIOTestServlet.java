package com.kosta.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@WebServlet("/FileIOTestServlet")
public class FileIOTestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext app = getServletContext();
        InputStream is = app.getResourceAsStream("FileIOtest.java");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String s;
        while((s = br.readLine()) != null) {
            System.out.println(s);
        }
    }
}
