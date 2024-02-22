package hkmu.comps380f;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet(
        name = "activityServlet",
        urlPatterns = {"/do/*"}
)
public class ActivityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.recordSessionActivity(request);
        this.viewSessionActivity(request, response);
    }

    private void recordSessionActivity(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("activity") == null)
            session.setAttribute("activity", new CopyOnWriteArrayList<PageVisit>());

        @SuppressWarnings("unchecked")
        CopyOnWriteArrayList<PageVisit> visits
                = (CopyOnWriteArrayList<PageVisit>) session.getAttribute("activity");
        if (!visits.isEmpty()) {
            PageVisit last = visits.get(visits.size() - 1);
            last.setLeftTimestamp(System.currentTimeMillis());
        }

        PageVisit now = new PageVisit();
        now.setEnteredTimestamp(System.currentTimeMillis());
        if (request.getQueryString() == null) now.setRequest(request.getRequestURL().toString());
        else now.setRequest(request.getRequestURL() + "?" + request.getQueryString());
        try {
            now.setIpAddress(InetAddress.getByName(request.getRemoteAddr()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        visits.add(now);
    }

    private void viewSessionActivity(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/viewSessionActivity.jsp")
                .forward(request, response);
    }
}
