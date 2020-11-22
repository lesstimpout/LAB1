<%@ page import="tables.CommonTable" %>
<%@ page import="javax.inject.Inject" %>
<%@ page import="entities.Agreement" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11/16/20
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User page</title>
    <style>
        body{
            font-family: Monserrat, sans-serif;
            margin-left: auto;
            margin-right: auto;
            text-align: center;
            width: 30%;
        }
        input{
            margin: 10px 0;
            padding: 10px;
            border: unset;
            border-bottom: 2px solid #e3e3e3;
            outline: none;
        }
        table {
            background: #e3e3e3;
            width: 100%;
            text-align: center;
        }
        th {
            font-weight: normal;
            font-size: 14px;
            color: #339;
            padding: 10px 12px;
            background: white;
        }
        td {
            color: #669;
            border-top: 1px solid white;
            padding: 10px 12px;
            background: rgba(51, 51, 153, .2);
            transition: .3s;
        }
        tr:hover td {
            background: rgba(51, 51, 153, .1);
        }
        .butt{
            padding: 10px;
            background: #e3e3e3;
            border: unset;
            cursor: pointer;
        }
    </style>
</head>
<body>
<%!
    @Inject
    CommonTable commonTable;
%>
<h2>Соглашение</h2>
<table>
    <tr>
        <td><b>Id</b></td>
        <td><b>Номер соглашения</b></td>
        <td><b>Id клиента</b></td>
        <td><b>Id страхового агента</b></td>
    </tr>
            <%
                List<Agreement> agreements = commonTable.getAgreementTable().getAgreements();
                for (int i = 0; i < agreements.size(); i++) {
                    %>
    <tr>
        <td><%=agreements.get(i).getId()%></td>
        <td><%=agreements.get(i).getAgreementNumber()%></td>
        <td><%=agreements.get(i).getClientId()%></td>
        <td><%=agreements.get(i).getAgentId()%></td>
    </tr>
    <% } %>
</table>
</body>
</html>
