<%@ page import="com.entity.Goods" %>
<%@ page import="com.util.CookieUtil" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: annan
  Date: 2019/4/4
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>shopDemo</title>
    <link rel="stylesheet" href="/assets/css/current.css">
    <style>

    </style>
</head>
<body>
<div>
    <div style="height: 50px;line-height:50px">
            <%
                Cookie[] cookies = request.getCookies();
                Cookie cookie = CookieUtil.getCookie(cookies,"username");
                if (cookie!=null&&!cookie.equals("")){
                    out.println("<a href=\"/mine\">" + cookie.getValue() + "</a>");
                }
                else {
                    out.println("<a href=\"/login.jsp\">" + "请登录" + "</a>");
                }
            %>
        <a href="/register.jsp">注册</a>
    </div>
    <div style="height: 100px;">
        <form action="/index" method="post">
            <input type="text" name="search"/>
            <button type="submit">搜索</button>
        </form>
    </div>
    <div>
        <%
            String search = (String) request.getAttribute("searchByName");
            if (search==null||search.equals("")){
                out.println("<div>商品列表</div>");
            }else {
                out.println("<div>搜索：<b>" + search + "</b></div>");
                out.println("<div>搜索结果：</div>");
            }
        %>
        <div>
            <table class="goodsList" border="1" style="margin: 0 auto">
                <tr>
                    <th><b>商品序号</b></th>
                    <th><b>商品名称</b></th>
                    <th><b>商品价格</b></th>
                    <th><b>商品介绍</b></th>
                </tr>
        <%
            List<Goods> list = (List<Goods>) request.getAttribute("goodsList");
            for (int i=0;i<list.size();i++){
                out.println("<tr>\n" +
                        "                    <td>" + (i+1) + "</td>\n" +
                        "                    <td>" + list.get(i).getName() + "</td>\n" +
                        "                    <td>" + list.get(i).getPrice() + "</td>\n" +
                        "                    <td>" + list.get(i).getDetail() + "</td>\n" +
                        "                </tr>");
            }
        %>
            </table>
        </div>
    </div>
</div>

</body>
</html>
