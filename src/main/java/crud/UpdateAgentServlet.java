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

@WebServlet(name = "UpdateAgentServlet")
public class UpdateAgentServlet extends HttpServlet {
    @Inject
    CommonTable commonTable;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("updateButton") != null){
            List<InsuranceAgent> agents = commonTable.getInsuranceAgentTable().getInsuranceAgents();
            int id = Integer.parseInt((String) request.getSession().getAttribute("agentId"));
            String name = request.getParameter("name");
            String lastname = request.getParameter("lastname");
            String agencyName = request.getParameter("agencyName");
            int agreementId = Integer.parseInt(request.getParameter("agreementId"));
            agents.set(id-1, new InsuranceAgent(id, name, lastname, agencyName, agreementId));
            response.sendRedirect("pages/adminPage.jsp");
        }
        else{
            request.getSession().setAttribute("agentId", request.getParameter("agentId"));
            request.getRequestDispatcher("crudPages/updateAgent.jsp").forward(request, response);
        }
    }
}
