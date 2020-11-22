package crud;

import entities.Agreement;
import entities.InsuranceAgent;
import sun.management.Agent;
import tables.CommonTable;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteAgentServlet")
public class DeleteAgentServlet extends HttpServlet {
    @Inject
    CommonTable commonTable;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<InsuranceAgent> agents = commonTable.getInsuranceAgentTable().getInsuranceAgents();
        List<Agreement> agreements = commonTable.getAgreementTable().getAgreements();
        int id = Integer.parseInt(request.getParameter("agentId"));
        agents.removeIf(agent -> agent.getId() == id);
        agreements.removeIf(agreement -> agreement.getClientId() == id);
        response.sendRedirect("pages/adminPage.jsp");
    }
}
