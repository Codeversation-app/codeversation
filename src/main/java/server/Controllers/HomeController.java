package server.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import server.models.PostThread;
import server.repositories.PostThreadRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Controller
@SessionAttributes("username")
public class HomeController {
    @Autowired
    PostThreadRepository postThreadRepository;

    @RequestMapping("/")
    public String home(Model model) {
        List<PostThread> questions = postThreadRepository.findByCategory("questions");
        List<PostThread> top5Questions = new LinkedList<>();

        Collections.sort(questions);

        for (int i = 0; i < 5; i++) {
            top5Questions.add(questions.get(i));
        }

        model.addAttribute("questions", top5Questions);
        return "index";
    }

    @RequestMapping("/about")
    public String about() { return "about"; }

}