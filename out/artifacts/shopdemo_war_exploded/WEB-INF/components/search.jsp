<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8" %>
<div>
    <div style="height: 100px;">
        <form action="/index" method="post">
            <input type="text" name="search"/>
            <button type="submit">搜索</button>
        </form>
    </div>
    <div>
        <c:choose>
            <c:when test="${requestScope.searchByName != null && requestScope.searchByName != ''}">
                <div>
                    搜索：<b>${requestScope.searchByName}</b>
                </div>
                <div>
                    搜索结果：
                </div>
            </c:when>
            <c:otherwise>
                <div>商品列表</div>
            </c:otherwise>
        </c:choose>
        <div>
            <table class="goodsList" border="1" style="margin: 0 auto">
                <tr>
                    <th><b>商品序号</b></th>
                    <th><b>商品名称</b></th>
                    <th><b>商品价格</b></th>
                    <th><b>商品介绍</b></th>
                </tr>
                <c:forEach items="${requestScope.goodsList}" var="row" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${row.name}</td>
                        <td>${row.price}</td>
                        <td>${row.detail}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
