package server.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import server.models.PostThread;
import server.models.Reply;
import server.models.User;
import server.repositories.PostThreadRepository;
import server.repositories.ReplyRepository;
import server.repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("username")
@RequestMapping("/forum")
public class ReplyController {
    @Autowired
    ReplyRepository replyRepository;

    @Autowired
    PostThreadRepository postThreadRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/{category}/{threadid}")
    public String getThreadDetail(
            Model model,
            @PathVariable("category") String category,
            @PathVariable("threadid") int threadid

    ){
        List<Reply> reply = replyRepository.findByThread(threadid);

        model.addAttribute("threadid", threadid);

        return "thread";
    }

    @PostMapping
    public String createReply(
            @RequestParam String title,
            @RequestParam String content,
            HttpServletRequest request
    ) {
        String pattern = "MMM dd yyyy HH:mm a z";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());

        HttpSession sesh = request.getSession();
        User user = (User) sesh.getAttribute("user");
        Thread thread = (Thread) sesh.getAttribute("threadid");

        Reply reply = replyRepository.save(new Reply(title, content, date, thread, user));

        return "redirect:/forum";
    }
}