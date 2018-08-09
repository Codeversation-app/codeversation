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
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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

    @RequestMapping("/reply/{category}/{id}")
    public String getThreadDetail(
            @PathVariable("category") String category,
            @PathVariable("id") String id,
            Model model
    ){
        Long intid = Long.parseLong(id);
        System.out.println("in getThreadDetail");
        List<User> users = userRepository.findAll();
        System.out.println(userRepository.findAll().get(0).username);

        List<PostThread> threads = postThreadRepository.findAll();
        System.out.println(postThreadRepository.findAll().get(0).id);
        Iterator<PostThread> threadIterator = threads.iterator();
        PostThread thread = threadIterator.next();
        while(thread.id != intid){
            thread = threadIterator.next();
            if(thread == null){
                return "/forum";
            }
        }

        List<Reply> replies = replyRepository.findAll();
        System.out.println(replyRepository.findAll().get(0).postThread.content);

        Iterator<Reply> replyIterator = replies.iterator();

        List<Reply> repliesByThread = new ArrayList<>();
        Reply currentReply = replyIterator.next();
        while(replyIterator != null){
            if(currentReply.postThread == thread){
                repliesByThread.add(currentReply);
            }
            if(replyIterator.hasNext()) {
                currentReply = replyIterator.next();
            }
        }

        model.addAttribute("users", users);
        model.addAttribute("threads", threads);
        model.addAttribute("replies", repliesByThread);
        model.addAttribute("category", category);
        model.addAttribute("thread",thread);

        return "thread";
    }

    @PostMapping("/reply/{category}/{id}/post")
    public String createReply(
            @PathVariable long id,
            @PathVariable String category,
            @RequestParam String content,
            HttpServletRequest request
    ) {
        String pattern = "MMM dd yyyy HH:mm a z";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());

        HttpSession sesh = request.getSession();
        User user = (User) sesh.getAttribute("user");

        List threads = postThreadRepository.findAll();
        Iterator<PostThread> threadIterator = threads.iterator();
        PostThread currentThread = new PostThread();
        boolean found = false;
        while(threadIterator != null && found == false){
            currentThread = threadIterator.next();
            if(currentThread.id == (int) id){
                found=true;
            }
        }
        if(found = false){
            return "redirect:/forum/reply/{category}/{id}";
        }

        Reply reply = replyRepository.save(new Reply(content, date, user, currentThread));

        return "redirect:/forum/reply/{category}/{id}";
    }
}