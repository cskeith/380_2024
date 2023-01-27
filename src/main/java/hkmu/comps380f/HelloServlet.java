package hkmu.comps380f;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.Date;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        Date today = new Date();
        out.println("<!DOCTYPE html><html><body>");
        out.println("<h1>It is now: " + today + "</h1>");
        out.println("</body></html>");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started.");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has ended.");
    }
}
