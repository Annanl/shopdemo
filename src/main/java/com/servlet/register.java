package com.servlet;

import com.dao.impl.constance.UserDaoImpl;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "register",urlPatterns = "/register")
public class register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        System.out.println("注册");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String phone = request.getParameter("phone");
        if (password==null||password2==null||username==null||phone==null||
                password.equals("")||password2.equals("")||username.equals("")||phone.equals("")){
            request.setAttribute("tip","请将信息填写完整");
            request.getRequestDispatcher( "/register.jsp").forward(request, response);
        }else if(!password.equals(password2)){
            request.setAttribute("tip","两次输入密码不同");
            request.getRequestDispatcher( "/register.jsp").forward(request, response);
        }else {
            UserDaoImpl udi = new UserDaoImpl();
            if (udi.findUserByName(username)){
                try {
                    if (udi.addUser(new User(username,phone,password))){
                        request.setAttribute("tip","注册成功,请登录");
                        request.getRequestDispatcher( "/login.jsp").forward(request, response);
                    }else {
                        request.setAttribute("tip","注册失败,发生未知错误");
                        request.getRequestDispatcher( "/register.jsp").forward(request, response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                request.setAttribute("tip","用户名已存在");
                request.getRequestDispatcher( "/register.jsp").forward(request, response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
