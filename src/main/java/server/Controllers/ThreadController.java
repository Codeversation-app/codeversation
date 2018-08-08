package server.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import server.models.PostThread;
import server.repositories.ReplyRepository;
import server.repositories.PostThreadRepository;
import server.repositories.UserRepository;

@Controller
@RequestMapping("/new-post")
public class ThreadController {
    @Autowired
    ReplyRepository replyRepository;

    @Autowired
    PostThreadRepository postThreadRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping
    public String getThreadForm(){
        return "new-post";
    }

    @PostMapping
    public String createThread(
            @RequestParam String title,
            @RequestParam String category,
            @RequestParam String content
    ) {
        PostThread thread = postThreadRepository.save(new PostThread(title, category, content));

        return "redirect:/forum";
    }
}