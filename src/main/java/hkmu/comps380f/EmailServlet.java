package hkmu.comps380f;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;

public class EmailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html>");
        out.println("<head><title>Email Form</title></head>");
        out.println("<body><h1>Email Form</h1>");
        out.println("<form method=\"post\" action=\"echoEmail\">");
        out.println("<p>Name: <input type=\"text\" name=\"name\" size=\"30\" /></p>");
        out.println("<p>Email address: <input type=\"text\" name=\"email\" size=\"30\" /></p>");
        out.println("<p><input type=\"submit\" value=\"Send\" /></p>");
        out.println("</form></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html><body>");
        out.println("Hello, " + name + "!");
        out.println("Your email address is " + email);
        out.println("</body></html>");
    }
}
