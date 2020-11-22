package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "servlets.LoginServlet")
public class LoginServlet extends HttpServlet {
    HttpSession session;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        if (session.getAttribute("usernameCookie") == null){
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{
            forwardToPage(session, request, response);
        }
    }

    private void forwardToPage(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        Cookie usernameCookie = (Cookie) session.getAttribute("usernameCookie");
        Cookie passwordCookie = (Cookie) session.getAttribute("passwordCookie");
        String name = usernameCookie.getValue();
        String pass = passwordCookie.getValue();
        try {
            if (name.equals(AuthorizationServlet.USERNAME) & pass.equals(AuthorizationServlet.USERPASS)){
                request.getRequestDispatcher("/pages/userPage.jsp").forward(request, response);
            }else if(name.equals(AuthorizationServlet.ADMINNAME) & pass.equals(AuthorizationServlet.ADMINPASS)){
                request.getRequestDispatcher("/pages/adminPage.jsp").forward(request, response);
            }
        } catch (ServletException | IOException e) {
        e.printStackTrace();
        }
    }
}
