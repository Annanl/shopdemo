<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8" %>
<div style="height: 50px;line-height:50px">
    <c:choose>
        <c:when test="${cookie['username'] eq null}">
            <a href="/login.jsp">请登录</a>
        </c:when>
        <c:otherwise>
            <a href="/mine">${cookie['username'].value}</a>
        </c:otherwise>
    </c:choose>
    <a href="/register.jsp">注册</a>
</div>