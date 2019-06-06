package com.servlet;

import com.dao.impl.constance.GoodsDaoImpl;
import com.entity.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class index extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        String search = req.getParameter("search");
        GoodsDaoImpl gdi = new GoodsDaoImpl();
        List<Goods> list = null;
        if (search==null){
            list = gdi.getGoodsList("");
            req.setAttribute("searchByName","");
        }else {
            list = gdi.getGoodsList(search);
            req.setAttribute("searchByName",search);
        }

        req.setAttribute("goodsList",list);
        req.getRequestDispatcher( "/WEB-INF/jsp/index.jsp").forward(req, resp);
    }
}
