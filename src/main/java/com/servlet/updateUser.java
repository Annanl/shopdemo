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

@WebServlet(name = "updateUser", urlPatterns = "/updateUser")
public class updateUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        String username = request.getParameter("newusername");
        String password = request.getParameter("newpassword");
        String password2 = request.getParameter("newpassword2");
        String phone = request.getParameter("newphone");
        if (password == null || password2 == null || username == null || phone == null ||
                password.equals("") || password2.equals("") || username.equals("") || phone.equals("")) {
            request.setAttribute("tip", "请将信息填写完整");
            //request.getRequestDispatcher( "/register.jsp").forward(request, response);
        } else if (!password.equals(password2)) {
            request.setAttribute("tip", "两次输入密码不同");
            //request.getRequestDispatcher( "/register.jsp").forward(request, response);
        } else {
            UserDaoImpl udi = new UserDaoImpl();
            try {
                String oldusername = "";
                Cookie[] cookies = request.getCookies();
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")) {
                        oldusername = cookie.getValue();
                        cookie.setValue(username);
                        response.addCookie(cookie);
                        break;
                    }
                }
                if (udi.updateUser(new User(username, phone, password), oldusername)) {
                    request.setAttribute("tip", "修改成功");
                    //request.getRequestDispatcher( "/login.jsp").forward(request, response);
                } else {
                    request.setAttribute("tip", "修改失败,发生未知错误");
                    //request.getRequestDispatcher( "/register.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        request.getRequestDispatcher("/mine").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
