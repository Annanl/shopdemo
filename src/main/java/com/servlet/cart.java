package com.servlet;

import com.dao.impl.constance.CartDaoImpl;
import com.entity.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cart")
public class cart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartDaoImpl cart = new CartDaoImpl();
        String userid = (String) req.getParameter("userid");
        List<Goods> list = cart.getCart(userid);
        req.setAttribute("list",list);
        req.getRequestDispatcher("/WEB-INF/jsp/cart.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
