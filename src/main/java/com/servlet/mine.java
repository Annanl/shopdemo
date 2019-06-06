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

@WebServlet("/mine")
public class mine extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        UserDaoImpl udi = new UserDaoImpl();
        Cookie[] cookies = req.getCookies();
        User user = new User();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")){
                user = udi.getUser(cookie.getValue());
                break;
            }
        }
        req.setAttribute("user",user);
        req.getRequestDispatcher( "/WEB-INF/jsp/mine.jsp").forward(req, resp);
    }
}
