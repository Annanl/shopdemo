<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: annan
  Date: 2019/5/27
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <link rel="stylesheet" href="/assets/css/current.css">
</head>
<body>
<div>
    <c:import url="/WEB-INF/components/header.jsp"></c:import>
    <div>
        <br>
        <div>购物车列表</div>
        <br>
        <div>
            <table class="goodsList" border="1" style="margin: 0 auto">
                <tr>
                    <th><b>商品序号</b></th>
                    <th><b>商品名称</b></th>
                    <th><b>商品价格</b></th>
                    <th><b>商品介绍</b></th>
                    <th><b>商品数量</b></th>
                </tr>
                <c:forEach items="${requestScope.list}" var="row" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${row.name}</td>
                        <td>${row.price}</td>
                        <td>${row.detail}</td>
                        <td>${row.number}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
