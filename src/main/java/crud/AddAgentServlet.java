package crud;

import entities.Client;
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

@WebServlet(name = "AddAgentServlet")
public class AddAgentServlet extends HttpServlet {
    @Inject
    CommonTable commonTable;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<InsuranceAgent> agents = commonTable.getInsuranceAgentTable().getInsuranceAgents();
        int id = agents.stream().mapToInt(InsuranceAgent::getId).max().getAsInt() + 1;
        String name = request.getParameter("addNameVal");
        String lastName = request.getParameter("addLastNameVal");
        String agencyName = request.getParameter("addAgencyNameVal");
        int agreementId = Integer.parseInt(request.getParameter("addAgreementIdVal"));
        agents.add(new InsuranceAgent(id, name, lastName, agencyName, agreementId));
        response.sendRedirect("pages/adminPage.jsp");;
    }
}
