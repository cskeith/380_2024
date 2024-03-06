package hkmu.comps380f.model;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Ticket {
    private long id;
    private String customerName;
    private String subject;
    private String body;
    private Map<String, Attachment> attachments = new ConcurrentHashMap<>();

    // Getters and Setters of id, customerName, subject, body (not attachments)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Attachment getAttachment(String name) {
        return this.attachments.get(name);
    }

    public Collection<Attachment> getAttachments() {
        return this.attachments.values();
    }

    public void addAttachment(Attachment attachment) {
        this.attachments.put(attachment.getId(), attachment);
    }

    public int getNumberOfAttachments() {
        return this.attachments.size();
    }
}
