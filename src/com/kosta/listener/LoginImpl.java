package com.kosta.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener()
public class LoginImpl implements HttpSessionBindingListener {
    private int user_id;
    private String user_pw;
    private static int total_user = 0;

    public LoginImpl(int user_id, String user_pw) {
        this.user_id = user_id;
        this.user_pw = user_pw;
    }

    // Public constructor is required by servlet spec
    public LoginImpl() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    public static int getTotal_user() {
        return total_user;
    }

    public static void setTotal_user(int total_user) {
        LoginImpl.total_user = total_user;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        total_user++;
        System.out.println("접속성공...현재 접속자 수: " + total_user);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        total_user--;
        System.out.println("접속해제...현재 접속자 수: " + total_user);
    }
}
