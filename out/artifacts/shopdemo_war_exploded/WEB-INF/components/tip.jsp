<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="color: #ff6120">
    <c:if test="${requestScope.tip !=null}">
        ${requestScope.tip}
    </c:if>
</div>