<%--
  Created by IntelliJ IDEA.
  User: annan
  Date: 2019/5/25
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<div>
    <form action="/register" method="post">
        用户名：<input type="text" name="username"></br>
        密码：<input type="text" name="password"></br>
        确认密码：<input type="text" name="password2"></br>
        手机号：<input type="text" name="phone"></br>
        <div style="color: #ff6120">
            <%String tip = (String) request.getAttribute("tip");%>
            <%=(tip != null) ? tip : ""%>
        </div>
        <input type="submit" value="注册"></input>
    </form>
    <button><a href="/login.jsp">已有账号？去登录</a></button>
    <button><a href="/index">暂不注册</a></button>
</div>

</body>
</html>
