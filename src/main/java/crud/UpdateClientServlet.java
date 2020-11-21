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

@WebServlet(name = "UpdateClientServlet")
public class UpdateClientServlet extends HttpServlet {

    @Inject
    CommonTable commonTable;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("updateButton") != null){
            List<Client> clients = commonTable.getClientTable().getClients();
            int id = Integer.parseInt((String) request.getSession().getAttribute("clientId"));
            String name = request.getParameter("name");
            String lastname = request.getParameter("lastname");
            int agreementId = Integer.parseInt(request.getParameter("agreementId"));
            clients.set(id-1, new Client(id, name, lastname, agreementId));
            response.sendRedirect("pages/adminPage.jsp");
        }
        else{
            request.getSession().setAttribute("clientId", request.getParameter("clientId"));
            request.getRequestDispatcher("crudPages/updateClient.jsp").forward(request, response);
        }
    }
}
