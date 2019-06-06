<%@ page import="com.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: annan
  Date: 2019/5/5
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>我的</title>
</head>
<body>
<div>
    <a href="/index">
        <button>首页</button>
    </a>
    <form action="/logout">
        <input type="submit" value="登出">
    </form>
</div>
修改资料：
<div>
    <%
        User user = (User) request.getAttribute("user");
    %>
    <form action="/updateUser" method="post">
        用户名：<input type="text" name="newusername" value="
<%
        out.println(user.getUsername());
    %>
" /><br>
        密码：<input type="text" name="newpassword" value="
<%
        out.println(user.getPassword());
    %>
" /><br>
        确认密码：<input type="text" name="newpassword2" value="
<%
        out.println(user.getPassword());
    %>
" /><br>
        手机号：<input type="text" name="newphone" value="
<%
        out.println(user.getPhone());
    %>
" /><br>
        <div style="color: #ff6120">
            <%String tip = (String) request.getAttribute("tip");%>
            <%=(tip != null) ? tip : ""%>
        </div>
        <input type="submit" value="保存修改" />
    </form>
</div>
</body>
</html>
