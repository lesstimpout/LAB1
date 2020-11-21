<%--
  Created by IntelliJ IDEA.
  User: netno
  Date: 21.11.2020
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование соглашения</title>
</head>
<body>
    <form action="/updateAgreement" method="get">
        <label>Номер соглашения</label> <input type="text" name="agreementNumber"><br>
        <label>Id клиента</label> <input type="text" name="clientId"><br>
        <label>Id агента</label> <input type="text" name="agentId"><br>
        <input type="submit" name="updateButton">
    </form>
</body>
</html>
