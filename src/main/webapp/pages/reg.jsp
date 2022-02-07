<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.01.2022
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">
    </a>
    <a class="navbar-brand" href="/">HOME</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link" href="/registration">Registration</a>
            <a class="nav-item nav-link" href="/authorization">Authorization</a>
    </div>
    </div>
</nav>
<form action="/registration" method="post">
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-5">
                <div class="form-group row my-2">
                    <label class="col-sm-2 col-form-label">Name</label>
                    <div class="col-sm-10">
                        <input type="text" name="name" class="form-control" placeholder="Name" required>
                    </div>
                </div>
                <div class="form-group row my-2">
                    <label class="col-sm-2 col-form-label">Username</label>
                    <div class="col-sm-10">
                        <input type="text" name="userName" class="form-control" placeholder="Username" required>
                        <c:if test="${requestScope.message!=null}">

                                    <input type="text" class="form-control alert alert-danger my-2" value="${requestScope.message}">

                        </c:if>
                    </div>
                </div>
                <div class="form-group row my-2">
                    <label class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-10">
                        <input type="text" name="pass" class="form-control" placeholder="Pass" required>
                    </div>
                </div>
            <div class="form-group row my-2">
                    <label class="col-sm-3 col-form-label">Secret question</label>
                <div class="form-group col-md-3">
                    <select name = "question" class="form-control">
                        <option selected>Choose...</option>
                        <option value="1">Name of your pet</option>
                        <option value="2">City were you born</option>
                        <option value="3">The name of the school where you studied</option>
                        <option value="4">Maiden name your mother</option>
                        <option value="5">Your favorite color</option>
                    </select>
                </div>
                <div class="form-group col-md-5">
                    <input type="text" name="answer" class="form-control" placeholder="Answer" required>
                </div>
            </div>
            <br>
            <button class="btn btn-outline-dark my-2">Submit</button>
            <br>
        </div>
    </div>
</div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
