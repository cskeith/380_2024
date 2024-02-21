package hkmu.comps380f;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddComment", value = "/AddComment")
public class AddComment extends HttpServlet {
    int numComment = 0;

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
        request.getRequestDispatcher("/WEB-INF/jsp/AddComment.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get the user input
        String name = request.getParameter("name");
        String message = request.getParameter("message");

        // create a new guest book entry
        GuestBookEntry entry = new GuestBookEntry(++numComment, name, message);

        // add the new entry to the guest book
        List<GuestBookEntry> entries
                = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
        entries.add(entry);

        // send the user back to the guest book page
        response.sendRedirect("GuestBook");
    }
}
