package hkmu.comps380f;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
}
