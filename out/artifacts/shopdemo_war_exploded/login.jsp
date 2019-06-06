<%--
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
</head>
<body>
<h1>欢迎</h1>
<div>
    <form action="/login" method="post">
        用户名：<input type="text" name="username"></br>
        密码：<input type="text" name="password"></br>
        <div style="color: #ff6120">
            <%String tip = (String)request.getAttribute("tip");%>
            <%=(tip!=null)?tip:""%>
        </div>
        <input type="submit" value="登录"></input>
    </form>
    <button><a href="/register.jsp">注册</a></button>
    <button><a href="/index">暂不登录</a></button>
</div>
</body>
</html>
