package hkmu.comps380f;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/dynamic")
    public String dynamicindex(ModelMap map) {
        map.addAttribute("hello", "Welcome to COMPS380F Spring Lecture !");
        return "myindex";
    }

    @GetMapping("/myform")
    public ModelAndView myform() {
        return new ModelAndView("myform", "myData", new MyData());
    }

    @PostMapping("/formhandle")
    public String formHandle(MyData mydata, ModelMap map) {
        map.addAttribute("data", mydata);
        return "myoutput";
    }
}
