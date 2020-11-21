<%--
  Created by IntelliJ IDEA.
  User: netno
  Date: 21.11.2020
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование клиента</title>
</head>
<body>
    <form action="/updateClient" method="get">
       <label>Имя</label> <input type="text" name="name"><br>
        <label>Фамилия</label> <input type="text" name="lastname"><br>
        <label>Id соглашения</label> <input type="text" name="agreementId"><br>
        <input type="submit" name="updateButton">
    </form>
</body>
</html>
