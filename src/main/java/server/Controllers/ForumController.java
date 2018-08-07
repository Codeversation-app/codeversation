package server.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class ForumController {
    // Returns the forum template
    @RequestMapping("/forum")
    public String forum() {
        return "forum";
    }
}
