<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11/16/20
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
    <form action="/authorization" method="post" style="padding: 10px 10px 10px 10px">
        <label>Username </label> <input type="text" name="username"><br>
        <label>Password </label> <input type="password" name="password"><br>
        <input type="submit" value="Sign in">
    </form>
</body>
</html>
