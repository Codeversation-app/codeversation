package server.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import server.models.PostThread;
import server.repositories.ReplyRepository;
import server.repositories.PostThreadRepository;
import server.repositories.UserRepository;

import java.util.Collections;
import java.util.List;

@Controller
@SessionAttributes("username")
@RequestMapping("/forum")
public class ForumSectionController {
    @Autowired
    PostThreadRepository postThreadRepository;

    @Autowired
    ReplyRepository replyRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/general")
    public String getGeneralChat (Model model) {
        List<PostThread> postThread = postThreadRepository.findByCategory("general");
        model.addAttribute("threads", postThread);
        model.addAttribute("category", "General");
//        String username = userRepository.findOne("username", );
//        model.addAttribute("username", username);

        return "section";
    }

    @RequestMapping("/questions")
    public String getQuestions (Model model) {
        List<PostThread> postThread = postThreadRepository.findByCategory("questions");
        model.addAttribute("threads", postThread);
        model.addAttribute("category", "Questions and Answers");

        return "section";
    }

    @RequestMapping("/collab-corner")
    public String getCollab (Model model) {
        List<PostThread> postThread = postThreadRepository.findByCategory("collab");
        model.addAttribute("threads", postThread);
        model.addAttribute("category", "Collaboration Corner");

        return "section";
    }

    @RequestMapping("/news")
    public String getNews (Model model) {
        List<PostThread> postThread = postThreadRepository.findByCategory("news");
        model.addAttribute("threads", postThread);
        model.addAttribute("category", "Tech News");

        return "section";
    }

    @RequestMapping("/jobs")
    public String getJobs (Model model) {
        List<PostThread> postThread = postThreadRepository.findByCategory("jobs");
        model.addAttribute("threads", postThread);
        model.addAttribute("category", "Job Postings");

        return "section";
    }
}
