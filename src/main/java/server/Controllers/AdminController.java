package server.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import server.models.User;
import server.repositories.PostThreadRepository;
import server.repositories.ReplyRepository;
import server.repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@SessionAttributes("username")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ReplyRepository replyRepository;

    @Autowired
    PostThreadRepository postThreadRepository;

    @RequestMapping("/ban")
    public String banUser (
            @RequestParam("nameToBan") String targetUser,
            HttpServletRequest request,
            Model model
    ) {

        List<User> users = userRepository.findByUsername(targetUser);
        User target = users.get(0);
        target.status = 0;
        target.username += "(Banned)";
        userRepository.save(target);
        return "/forum";
    }
}