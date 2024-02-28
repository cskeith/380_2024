package hkmu.comps380f;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String index() {
        return "myindexstatic";
    }

    @GetMapping({"/now", "/time"})
    public String showTime() {
        return "currentTime";
    }
}
