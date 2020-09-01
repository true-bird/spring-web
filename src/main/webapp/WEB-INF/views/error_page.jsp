<%--
  Created by IntelliJ IDEA.
  User: kakao_ent
  Date: 2020/09/01
  Time: 3:46 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4><c:out value="${exception.getMessage()}"></c:out></h4>
    <ul>
        <c:forEach items="${exception.getStackTrace() }" var="stack">
            <li><c:out value="${stack}"></c:out></li>
        </c:forEach>
    </ul>
</body>
</html>
