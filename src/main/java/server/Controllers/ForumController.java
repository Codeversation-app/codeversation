package server.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("username")
public class ForumController {
    // Returns the forum template
    @RequestMapping("/forum")
    public String forum(Model model, HttpServletRequest request) {
        if(request.getSession().getAttribute("loggedin").equals(false) ||request.getSession().getAttribute("loggedin").equals((null))){
            return "redirect:/login";
        }
        //These both need warnings so the user logs back in.
         return "index";
    }
}
