<%@ page import="tables.CommonTable" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.Client" %>
<%@ page import="entities.InsuranceAgent" %>
<%@ page import="entities.Agreement" %>
<%@ page import="javax.inject.Inject" %>
<%@ page import="tables.ClientTable" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11/16/20
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
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
<h2>Клиенты</h2>
    <table>
        <tr align='center'>
            <td><b>Id</b></td>
            <td><b>Имя</b></td>
            <td><b>Фамилия</b></td>
            <td><b>Id соглашения</b></td>
        </tr>
        <tr>
            <%!
                @Inject
                CommonTable commonTable;
                %>
            <%
                List<Client> clients = commonTable.getClientTable().getClients();
                for (int i = 0; i < clients.size(); i++) {
                    %>
        <tr>
            <td><%=clients.get(i).getId()%></td>
        <td><%=clients.get(i).getName()%></td>
        <td><%=clients.get(i).getLastName()%></td>
        <td><%=clients.get(i).getAgreementId()%></td>
        <td>
            <form action="/updateClient" method="get">
                <input type="hidden" name="clientId" value="<%=clients.get(i).getId()%>">
                <input class="butt" type="submit" value="Изменить">
            </form>
        </td>
        <td>
            <form action="/deleteClient" method="get">
                <input type="hidden" name="clientId" value="<%=clients.get(i).getId()%>">
                <input class="butt" type="submit" value="Удалить">
            </form>
        </td>
        </tr>
                    <%
                }
                %>
        </table>
        <h2>Страховые агенты</h2>
        <table>
        <tr>
            <td><b>Id</b></td>
            <td><b>Имя</b></td>
            <td><b>Фамилия</b></td>
            <td><b>Название агентства</b></td>
            <td><b>Id соглашения</b></td>
    </tr>
    <tr>
        <%
                List<InsuranceAgent> insuranceAgents = commonTable.getInsuranceAgentTable().getInsuranceAgents();
                for (int i = 0; i < insuranceAgents.size(); i++) {
                    %>
        <tr>
            <td><%=insuranceAgents.get(i).getId()%></td>
            <td><%=insuranceAgents.get(i).getName()%></td>
            <td><%=insuranceAgents.get(i).getLastName()%></td>
            <td><%=insuranceAgents.get(i).getAgencyName()%></td>
            <td><%=insuranceAgents.get(i).getAgreementId()%></td>
            <td>
                <form action="/updateAgent" method="get">
                    <input type="hidden" name="agentId" value="<%=insuranceAgents.get(i).getId()%>">
                    <input class="butt" type="submit" value="Изменить">
                </form>
            </td>
            <td>
                <form action="/deleteAgent" method="get">
                    <input type="hidden" name="agentId" value="<%=insuranceAgents.get(i).getId()%>">
                    <input class="butt" type="submit" value="Удалить">
                </form>
            </td>
        </tr>
        <%
            }
        %>
        </tr>
    </table>

<h2>Соглашение</h2>
<table>
    <tr>
        <td><b>Id</b></td>
        <td><b>Номер соглашения</b></td>
        <td><b>Id клиента</b></td>
        <td><b>Id страхового агента</b></td>
    </tr>
    <tr>
            <%
                List<Agreement> agreements = commonTable.getAgreementTable().getAgreements();
                for (int i = 0; i < agreements.size(); i++) {
                    %>
    <tr>
        <td><%=agreements.get(i).getId()%></td>
        <td><%=agreements.get(i).getAgreementNumber()%></td>
        <td><%=agreements.get(i).getClientId()%></td>
        <td><%=agreements.get(i).getAgentId()%></td>
    <td>
        <form action="/updateAgreement" method="get">
            <input type="hidden" name="agreementId" value="<%=agreements.get(i).getId()%>">
            <input class="butt" type="submit" value="Изменить">
        </form>
    </td>
    <td>
        <form action="/deleteAgreement" method="get">
            <input type="hidden" name="agreementId" value="<%=agreements.get(i).getId()%>">
            <input class="butt" type="submit" value="Удалить">
        </form>
    </td>
    </tr>
    <%
        }
    %>
    </tr>
</table>
</body>
</html>
