package crud;

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

@WebServlet(name = "AddClientServlet")
public class AddClientServlet extends HttpServlet {
    @Inject
    CommonTable commonTable;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Client> clients = commonTable.getClientTable().getClients();
        int id = clients.stream().mapToInt(Client::getId).max().getAsInt() + 1;
        String name = request.getParameter("addNameVal");
        String lastName = request.getParameter("addLastNameVal");
        int agreementId = Integer.parseInt(request.getParameter("addAgreementIdVal"));
        clients.add(new Client(id, name, lastName, agreementId));
        response.sendRedirect("pages/adminPage.jsp");;
    }
}
