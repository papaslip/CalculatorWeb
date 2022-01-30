<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.01.2022
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Home</title>
</head>
<body>
<c:if test="${sessionScope.user == null}">
  <a href="/registration">Registration</a>
  <a href="/authorization">Authorization</a>
</c:if>
<c:if test="${sessionScope.user != null}">
  <a href="/calculator">Calculator</a>
  <a href="/logout">Logout</a>
</c:if>

</body>
</html>
