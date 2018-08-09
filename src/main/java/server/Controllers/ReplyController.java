package server.Controllers;

import javafx.geometry.Pos;
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

    @RequestMapping("/reply")
    public String getThreadDetail(
        Model model
//        @PathVariable("category") String category,
//        @PathVariable("threadid") int threadid
    ){
        System.out.println("in getThreadDetail");
        List<Reply> reply = replyRepository.findAll();
//
        model.addAttribute("replies", reply);

        return "thread";
    }

    @PostMapping
    public String createReply(
//            @RequestParam String title,
            @RequestParam String content,
            HttpServletRequest request
    ) {
        String pattern = "MMM dd yyyy HH:mm a z";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());

        HttpSession sesh = request.getSession();
        User user = (User) sesh.getAttribute("user");
        PostThread postThread = (PostThread) sesh.getAttribute("threadid");
        Reply reply = replyRepository.save(new Reply(content, date, user, postThread));

        return "redirect:/forum";
    }
}