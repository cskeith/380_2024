package hkmu.comps380f;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class VisitCounterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        Integer count;
        synchronized (context) {
            count = (Integer) context.getAttribute("counter");
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            context.setAttribute("counter", count);
        }
        ServletConfig config = this.getServletConfig();
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append(" <head>\r\n")
                .append(" <title>" + config.getInitParameter("title") + "</title>\r\n")
                .append(" </head>\r\n")
                .append(" <body>\r\n")
                .append("<h1>" + config.getInitParameter("title") + "</h1>\r\n")
                .append(" The site " + context.getInitParameter("title"))
                .append(" was visited for " + count + " times.\r\n")
                .append(" </body>\r\n")
                .append("</html>\r\n");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started.");
    }
    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped.");
    }
}
