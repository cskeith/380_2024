package hkmu.comps380f;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "emailServlet", value = "/echoEmail")
public class EmailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view
                = request.getRequestDispatcher("/WEB-INF/jsp/email_form.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view
                = request.getRequestDispatcher("/WEB-INF/jsp/email_echo.jsp");
        view.forward(request, response);
    }

}
