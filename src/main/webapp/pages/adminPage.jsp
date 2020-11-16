<%@ page import="tables.CommonTable" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.Client" %>
<%@ page import="entities.InsuranceAgent" %>
<%@ page import="entities.Agreement" %><%--
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
            <%
                CommonTable commonTable = new CommonTable();
                List<Client> clients = commonTable.getClientTable().getClients();
                List<InsuranceAgent> insuranceAgents = commonTable.getInsuranceAgentTable().getInsuranceAgents();
                List<Agreement> agreements = commonTable.getAgreementTable().getAgreements();
                for (int i = 0; i < clients.size(); i++) {
                    %>
        <tr>
            <td><%clients.get(i).getId();%></td>
        <td><%clients.get(i).getName();%></td>
        <td><%clients.get(i).getLastName();%></td>
        <td><%clients.get(i).getAgreementId();%></td>
        </tr>
                    <%
                }
            %>
        </tr>
    </table>
</body>
</html>
