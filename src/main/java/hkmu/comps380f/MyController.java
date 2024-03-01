package hkmu.comps380f;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class MyController {

    @GetMapping("/")
    public String index() {
        return "viewSessionActivity";
    }

    @GetMapping("/checkboxes")
    public String multiValueForm() {
        return "MultiValueForm";
    }

    @PostMapping("/checkboxes")
    public String multiValueResult() {
        return "MultiValueResult";
    }

    @GetMapping("/do/*")
    public String recordSessionActivity(HttpServletRequest request, HttpSession session) {
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
        return "viewSessionActivity";
    }
}
