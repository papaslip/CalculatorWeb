<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.01.2022
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<form action="/authorization" method="post">
    <input type="text" name="userName" placeholder="Username">
    <br>
    <input type="text" name="pass" placeholder="Password">
    <br>
    <button>Submit</button>
    <br>
    <a href="/">Go back</a>
</form>
<p>${requestScope.message}</p>
</body>
</html>
