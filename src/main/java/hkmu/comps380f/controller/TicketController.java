package hkmu.comps380f.controller;

import hkmu.comps380f.model.Attachment;
import hkmu.comps380f.model.Ticket;
import hkmu.comps380f.view.DownloadingView;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;
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

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("add", "ticketForm", new Form());
    }

    public static class Form {
        private String customerName;
        private String subject;
        private String body;
        private List<MultipartFile> attachments;

        // Getters and Setters of customerName, subject, body, attachments
        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public List<MultipartFile> getAttachments() {
            return attachments;
        }

        public void setAttachments(List<MultipartFile> attachments) {
            this.attachments = attachments;
        }
    }

    @PostMapping("/create")
    public View create(Form form) throws IOException {
        Ticket ticket = new Ticket();
        ticket.setId(this.getNextTicketId());
        ticket.setCustomerName(form.getCustomerName());
        ticket.setSubject(form.getSubject());
        ticket.setBody(form.getBody());

        for (MultipartFile filePart : form.getAttachments()) {
            Attachment attachment = new Attachment();
            attachment.setId(RandomStringUtils.randomAlphanumeric(8));
            attachment.setName(filePart.getOriginalFilename());
            attachment.setMimeContentType(filePart.getContentType());
            attachment.setContents(filePart.getBytes());
            if (attachment.getName() != null && attachment.getName().length() > 0
                    && attachment.getContents() != null && attachment.getContents().length > 0)
                ticket.addAttachment(attachment);
        }
        this.ticketDatabase.put(ticket.getId(), ticket);
        return new RedirectView("/ticket/view/" + ticket.getId(), true);
    }

    private synchronized long getNextTicketId() {
        return this.TICKET_ID_SEQUENCE++;
    }

    @GetMapping("/view/{ticketId}")
    public String view(@PathVariable("ticketId") long ticketId,
                       ModelMap model) {
        Ticket ticket = this.ticketDatabase.get(ticketId);
        if (ticket == null) {
            return "redirect:/ticket/list";
        }
        model.addAttribute("ticketId", ticketId);
        model.addAttribute("ticket", ticket);
        return "view";
    }

    @GetMapping("/{ticketId}/attachment/{attachment:.+}")
    public View download(@PathVariable("ticketId") long ticketId,
                         @PathVariable("attachment") String AttachmentId) {
        Ticket ticket = this.ticketDatabase.get(ticketId);
        if (ticket != null) {
            Attachment attachment = ticket.getAttachment(AttachmentId);
            if (attachment != null)
                return new DownloadingView(attachment.getName(),
                        attachment.getMimeContentType(), attachment.getContents());
        }
        return new RedirectView("/ticket/list", true);
    }
}
