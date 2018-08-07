package server.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class ProfileController {
    @RequestMapping("/profile")
    public String forum() {
        return "profile";
    }
}