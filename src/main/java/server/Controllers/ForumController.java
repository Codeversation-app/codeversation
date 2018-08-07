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
    public String forum(Model model) {
        //These both need warnings so the user logs back in.
        if(!model.containsAttribute("username")){return "redirect:/login";}
        if(model.asMap().get("username")==null){return "redirect:/login";}
        return "forum";
    }
}
