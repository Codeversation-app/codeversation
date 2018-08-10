package server.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import server.models.PostThread;
import server.repositories.PostThreadRepository;

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
        List<PostThread> general = postThreadRepository.findByCategory("general");
        List<PostThread> jobs = postThreadRepository.findByCategory("jobs");
        List<PostThread> collab = postThreadRepository.findByCategory("collab");
        List<PostThread> news = postThreadRepository.findByCategory("news");

        List<PostThread> top5Questions = new LinkedList<>();

        List<Integer> numberOfThreads = new LinkedList<>();

        numberOfThreads.add(general.size());
        numberOfThreads.add(questions.size());
        numberOfThreads.add(collab.size());
        numberOfThreads.add(news.size());
        numberOfThreads.add(jobs.size());

        Collections.sort(questions);

        for (int i = 0; i < 5; i++) {
            if(questions.size()>i){top5Questions.add(questions.get(i));}
        }

        model.addAttribute("questions", top5Questions);
        model.addAttribute("numberOfThreads",numberOfThreads);
        return "index";
    }

    @RequestMapping("/about")
    public String about() { return "about"; }

}