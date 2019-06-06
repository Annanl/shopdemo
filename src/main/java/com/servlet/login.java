package com.servlet;

import com.dao.impl.constance.UserDaoImpl;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        User user = null;
        UserDaoImpl u = new UserDaoImpl();
        if (username!=null&&password!=null&&!username.equals("")&&!password.equals("")){
            try {
                user = u.login(username,password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (user!=null&&user.getUsername()!=null&&!user.getUsername().equals("")){
                request.getSession().setAttribute("username",user.getUsername());
                Cookie cookie = new Cookie("username",user.getUsername());
                cookie.setMaxAge(2*24*60*60);
                response.addCookie(cookie);
                response.sendRedirect("/index");
                //request.getRequestDispatcher( "/index").forward(request, response);
            }else {
                String tip = "用户名或密码错误";
                request.setAttribute("tip",tip);
                //response.sendRedirect("/login.jsp");
                request.getRequestDispatcher( "/login.jsp").forward(request, response);
            }
        }else {
            String tip = "用户名和密码不能为空";
            request.setAttribute("tip",tip);
            //response.sendRedirect("/login.jsp");
            request.getRequestDispatcher( "/login.jsp").forward(request, response);
        }

    }
}
