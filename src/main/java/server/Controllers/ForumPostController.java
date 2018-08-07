package server.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import server.models.PostThread;
import server.repositories.PostRepository;
import server.repositories.PostThreadRepository;

import java.util.Collections;
import java.util.List;

@Controller
@SessionAttributes("username")
@RequestMapping("/forum")
public class ForumPostController {
    @Autowired
    PostThreadRepository postThreadRepository;

    @Autowired
    PostRepository postRepository;

    @RequestMapping("/general")
    public String getGeneralChat (Model model) {
        List<PostThread> postThread = postThreadRepository.findByCategory("general");
        Collections.sort(postThread);
        model.addAttribute("threads", postThread);

        return "section";
    }
}
