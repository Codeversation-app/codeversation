package server.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import server.models.PostThread;
import server.models.User;
import server.repositories.ReplyRepository;
import server.repositories.PostThreadRepository;
import server.repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Controller
@SessionAttributes("username")
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
            @RequestParam String content,
            HttpServletRequest request
    ) {
        String pattern = "MMM dd yyyy HH:mm a z";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());



        System.out.println(date);

        HttpSession sesh = request.getSession();
        User user = (User) sesh.getAttribute("user");
        PostThread thread = postThreadRepository.save(new PostThread(title, category, content, date, user));

        return "redirect:/forum";
    }
}