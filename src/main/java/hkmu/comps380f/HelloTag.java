package hkmu.comps380f;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {

    private String form;

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            String greeting = null;
            if (form.equals("brief"))
                greeting = "Hi";
            if (form.equals("effusive"))
                greeting = "My dearest";
            if (form.equals("serious"))
                greeting = "Now look here";
            out.print(greeting + " ");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in HelloTag tag", ex);
        }
    }

    public void setForm(String form) {
        this.form = form;
    }
}
