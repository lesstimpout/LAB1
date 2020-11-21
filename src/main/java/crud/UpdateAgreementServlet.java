package crud;

import entities.Agreement;
import entities.Client;
import tables.CommonTable;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpdateAgreementServlet")
public class UpdateAgreementServlet extends HttpServlet {
    @Inject
    CommonTable commonTable;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("updateButton") != null){
            List<Agreement> agreements = commonTable.getAgreementTable().getAgreements();
            int id = Integer.parseInt((String) request.getSession().getAttribute("agreementId"));
            String agreementNumber = request.getParameter("agreementNumber");
            int clientId = Integer.parseInt(request.getParameter("clientId"));
            int agentId = Integer.parseInt(request.getParameter("agentId"));
            agreements.set(id-1, new Agreement(id, agreementNumber, clientId, agentId));
            response.sendRedirect("pages/adminPage.jsp");
        }
        else{
            request.getSession().setAttribute("agreementId", request.getParameter("agreementId"));
            request.getRequestDispatcher("crudPages/updateAgreement.jsp").forward(request, response);
        }
    }
}
