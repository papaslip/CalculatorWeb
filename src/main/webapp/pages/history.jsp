<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 30.01.2022
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>History</title>
</head>
<body>
<ul>
    <c:forEach items="${sessionScope.calculator.getOperationStorage()}" var="item">
        <li>${item}</li>
    </c:forEach>
</ul>
<a href="/calculator">Go back</a>
</body>
</html>
