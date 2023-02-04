package hkmu.comps380f;

import java.io.Serializable;

public class HelloBean implements Serializable {
    private String name;
    private String email;

    public HelloBean() {}

    public String getName() { return name; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
}
