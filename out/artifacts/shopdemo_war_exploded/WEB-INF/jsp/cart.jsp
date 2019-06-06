<%@ page import="com.entity.Goods" %>
<%@ page import="com.util.CookieUtil" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: annan
  Date: 2019/5/27
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <link rel="stylesheet" href="/assets/css/current.css">
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
    </div>
    <div>
        <div>
            <table class="goodsList" border="1" style="margin: 0 auto">
                <tr>
                    <th><b>序号</b></th>
                    <th><b>商品名称</b></th>
                    <th><b>单价</b></th>
                    <th><b>购买数量</b></th>
                    <th><b>商品介绍</b></th>
                    <th><b>操作</b></th>
                </tr>
                <%
                    List<Goods> list = (List<Goods>) request.getAttribute("goodsList");
                    for (int i=0;i<list.size();i++){
                        out.println("<tr>\n" +
                                "                    <td>" + (i+1) + "</td>\n" +
                                "                    <td>" + list.get(i).getName() + "</td>\n" +
                                "                    <td>" + list.get(i).getPrice() + "</td>\n" +
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
