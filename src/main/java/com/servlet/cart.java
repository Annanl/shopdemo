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
        System.out.println("购物车打开");
        CartDaoImpl cart = new CartDaoImpl();
        List<Goods> list = cart.getCart("11");
        for (int i=0;i<list.size();i++){
            System.out.println("**********");
            System.out.print(list.get(i).getId() + "\t");
            System.out.print(list.get(i).getName() + "\t");
            System.out.print(list.get(i).getPrice() + "\t");
            System.out.print(list.get(i).getDetail() + "\t");
            System.out.println(list.get(i).getNumber() + "\t");
        }
        req.getRequestDispatcher("/WEB-INF/jsp/cart.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
