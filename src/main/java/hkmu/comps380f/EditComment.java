package hkmu.comps380f;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EditComment", value = "/EditComment")
public class EditComment extends HttpServlet {
    @SuppressWarnings("unchecked")
    private GuestBookEntry getEntry(Integer id) {
        List<GuestBookEntry> entries
                = (List<GuestBookEntry>) this.getServletContext().getAttribute("entries");
        for (GuestBookEntry entry : entries) {
            if (entry.getId().equals(id)) {
                return entry;
            }
        }
        return null;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get the entry to be edited
        Integer id = Integer.valueOf(request.getParameter("id"));
        GuestBookEntry entry = getEntry(id);

        // pass the entry to jsp using request scope
        request.setAttribute("entry", entry);
        request.getRequestDispatcher("/WEB-INF/jsp/EditComment.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get the entry to be edited
        Integer id = Integer.valueOf(request.getParameter("id"));
        GuestBookEntry entry = getEntry(id);

        // change the entry based on user input
        entry.setName(request.getParameter("name"));
        entry.setMessage(request.getParameter("message"));

        // send the user back to the guest book page
        response.sendRedirect("GuestBook");
    }
}