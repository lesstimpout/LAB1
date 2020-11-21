package crud;

import entities.Agreement;
import entities.InsuranceAgent;
import tables.CommonTable;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddAgreementServlet")
public class AddAgreementServlet extends HttpServlet {
    @Inject
    CommonTable commonTable;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Agreement> agreements = commonTable.getAgreementTable().getAgreements();
        int id = agreements.stream().mapToInt(Agreement::getId).max().getAsInt() + 1;
        String agreementNumber = request.getParameter("addAgreementNumberVal");
        int clientId = Integer.parseInt(request.getParameter("addClientIdVal"));
        int agentId = Integer.parseInt(request.getParameter("addAgentIdVal"));
        agreements.add(new Agreement(id, agreementNumber, clientId, agentId));
        response.sendRedirect("pages/adminPage.jsp");;
    }
}
