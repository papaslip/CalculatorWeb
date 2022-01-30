<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.01.2022
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/calculator" method="post">
    <input type="text" name="num1" placeholder="Number1">
    <br>
    <input type="text" name="num2" placeholder="Number2">
    <br>
    <input type="text" name="operator" placeholder="Operator">
    <br>
    <button>Submit</button>
    <br>
    <a href="/">Go back</a>
    <a href="/history">History</a>
</form>
<p>${requestScope.calculatorMessage}</p>
</body>
</html>
