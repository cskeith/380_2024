package hkmu.comps380f.controller;

import hkmu.comps380f.model.Ticket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("/ticket")
public class TicketController {
    private volatile long TICKET_ID_SEQUENCE = 1;
    private Map<Long, Ticket> ticketDatabase = new ConcurrentHashMap<>();

    // Controller methods, Form-backing object, ...
    @GetMapping(value = {"", "/list"})
    public String list(ModelMap model) {
        model.addAttribute("ticketDatabase", ticketDatabase);
        return "list";
    }
}
