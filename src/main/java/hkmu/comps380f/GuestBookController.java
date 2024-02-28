package hkmu.comps380f;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("/GuestBook")
public class GuestBookController {
    private volatile int commentIdSequence = 1;
    private Map<Integer, GuestBookEntry> entries = new ConcurrentHashMap<>();

    private synchronized int getNextCommentId() {
        return this.commentIdSequence++;
    }

    @GetMapping({"", "/"})
    public String index(ModelMap model) {
        model.addAttribute("entries", entries.values());
        return "GuestBook";
    }

    @GetMapping("/AddComment")
    public ModelAndView addCommentForm() {
        return new ModelAndView("AddComment", "entry", new GuestBookEntry());
    }

    @PostMapping("/AddComment")
    public View addCommentHandle(@ModelAttribute("entry") GuestBookEntry gbEntry) {
        Integer id = getNextCommentId();
        gbEntry.setId(id);
        gbEntry.setDate(new Date());
        this.entries.put(id, gbEntry);
        return new RedirectView("."); // One way to redirect in Spring MVC
    }

    @GetMapping("/EditComment/{id}")
    public String editCommentForm(@PathVariable("id") Integer entryId, ModelMap model) {
        GuestBookEntry entry = this.entries.get(entryId);
        model.addAttribute("entry", entry);
        return "EditComment";
    }

    @PostMapping("/EditComment/{id}")
    public String editCommentHandle(@PathVariable("id") Integer entryId, @ModelAttribute("entry") GuestBookEntry gbEntry) {
        gbEntry.setDate(new Date());
        this.entries.put(entryId, gbEntry);
        return "redirect:.."; // Another way to redirect in Spring MVC
    }
}
