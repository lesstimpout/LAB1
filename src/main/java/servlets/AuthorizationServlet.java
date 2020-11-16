package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {
    public final static String USERNAME = "person";
    public final static String USERPASS = "pass";
    public final static String ADMINNAME = "admin";
    public final static String ADMINPASS = "password";
    HttpSession session;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String pass = request.getParameter("password");

        if (name.equals(USERNAME) & pass.equals(USERPASS)){
            insertIntoSession(name, pass, request, response, "/pages/userPage.jsp");
        }else if(name.equals(ADMINNAME) & pass.equals(ADMINPASS)){
            insertIntoSession(name, pass, request, response, "/pages/adminPage.jsp");
        }
    }

    private void insertIntoSession(String name, String pass, HttpServletRequest request, HttpServletResponse response, String URL) throws ServletException, IOException {
        Cookie usernameCookie = new Cookie("usernameCookie", name);
        Cookie passwordCookie = new Cookie("passwordCookie", pass);
        session = request.getSession();
        session.setAttribute("usernameCookie", usernameCookie);
        session.setAttribute("passwordCookie", passwordCookie);
        request.getRequestDispatcher(URL).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
