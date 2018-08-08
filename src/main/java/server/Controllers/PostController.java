package server.Controllers;

import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import server.models.Post;
import server.repositories.PostRepository;
import server.repositories.PostThreadRepository;
import server.repositories.UserRepository;

@Controller
@RequestMapping("/new-post")
public class PostController {
    @Autowired
    PostRepository postRepository;

    @Autowired
    PostThreadRepository postThreadRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping
    public String getPostForm(){
        return "new-post";
    }

    @PostMapping
    public String createPost(
            @RequestParam String title,
            @RequestParam String category,
            @RequestParam String content
    ) {
        Post post = postRepository.save(new Post(title, category, content));

        return "redirect:/forum";
    }
}