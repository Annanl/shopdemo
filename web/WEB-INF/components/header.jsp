<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8" %>
<div style="height: 50px;line-height:50px">
    <form action="/cart" method="post" id="form">
        <a href="/index">首页</a>
        <c:choose>
            <c:when test="${cookie['username'] eq null}">
                <a href="/login.jsp">请登录</a>
                <a href="javascript:void(0)" onclick="alert('请登录')">购物车</a>
            </c:when>
            <c:otherwise>
                <a href="/mine">${cookie['username'].value}</a>
                <input type="hidden" name="userid" value="${cookie['userid'].value}" />
                <a href="javascript:void(0)" onclick="document:form.submit()">购物车</a>
            </c:otherwise>
        </c:choose>
        <a href="/register.jsp">注册</a>
    </form>
</div>