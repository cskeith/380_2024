package hkmu.comps380f.controller;

import hkmu.comps380f.dao.TicketService;
import hkmu.comps380f.exception.AttachmentNotFound;
import hkmu.comps380f.exception.TicketNotFound;
import hkmu.comps380f.model.Attachment;
import hkmu.comps380f.model.Ticket;
import hkmu.comps380f.view.DownloadingView;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/ticket")
public class TicketController {
    @Resource
    private TicketService tService;

    // Controller methods, Form-backing object, ...
    @GetMapping(value = {"", "/list"})
    public String list(ModelMap model) {
        model.addAttribute("ticketDatabase", tService.getTickets());
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
        long ticketId = tService.createTicket(form.getCustomerName(),
                form.getSubject(), form.getBody(), form.getAttachments());
        return new RedirectView("/ticket/view/" + ticketId, true);
    }

    @GetMapping("/view/{ticketId}")
    public String view(@PathVariable("ticketId") long ticketId,
                       ModelMap model)
            throws TicketNotFound {
        Ticket ticket = tService.getTicket(ticketId);
        model.addAttribute("ticketId", ticketId);
        model.addAttribute("ticket", ticket);
        return "view";
    }

    @GetMapping("/{ticketId}/attachment/{attachment:.+}")
    public View download(@PathVariable("ticketId") long ticketId,
                         @PathVariable("attachment") UUID attachmentId)
            throws TicketNotFound, AttachmentNotFound {
        Attachment attachment = tService.getAttachment(ticketId, attachmentId);
        return new DownloadingView(attachment.getName(),
                attachment.getMimeContentType(), attachment.getContents());
    }

    @GetMapping("/delete/{ticketId}")
    public String deleteTicket(@PathVariable("ticketId") long ticketId)
            throws TicketNotFound {
        tService.delete(ticketId);
        return "redirect:/ticket/list";
    }

    @GetMapping("/{ticketId}/delete/{attachment:.+}")
    public String deleteAttachment(@PathVariable("ticketId") long ticketId,
                                   @PathVariable("attachment") UUID attachmentId)
            throws TicketNotFound, AttachmentNotFound {
        tService.deleteAttachment(ticketId, attachmentId);
        return "redirect:/ticket/view/" + ticketId;
    }


    @ExceptionHandler({TicketNotFound.class, AttachmentNotFound.class})
    public ModelAndView error(Exception e) {
        return new ModelAndView("error", "message", e.getMessage());
    }
}
