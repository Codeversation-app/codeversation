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
import java.util.Iterator;
import java.util.LinkedList;
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
        Iterator<PostThread> iterator = postThread.iterator();
        LinkedList<PostThread> postOrder = new LinkedList<>();
        //LinkedList<Integer> numberOfReplies = new LinkedList<>();
        //if(model.asMap().get("sortMethod")=="score"){
        //    Collections.sort(postThread,score);
        //}
        //This boolean is just here as a placeholder so the site can be ran before we have everything set up.
        if(false){}
        else{
            while(iterator.hasNext()) {
        //        PostThread bleh = iterator.next();
                postOrder.push(iterator.next());
        //        numberOfReplies.push(replyRepository.findByPostThread(postOrder.peek().id).size());
            }
            postThread.removeAll(postThread);
            while(!postOrder.isEmpty()){
                postThread.add(postOrder.pop());
            }
        }
        model.addAttribute("threads", postThread);
        model.addAttribute("category", "General");

        //model.addAttribute("replyNumbers",numberOfReplies);
        //String username = userRepository.findOne("username", );
        //model.addAttribute("username", username);


        return "section";
    }

    @RequestMapping("/questions")
    public String getQuestions (Model model) {
        List<PostThread> postThread = postThreadRepository.findByCategory("questions");
        Iterator<PostThread> iterator = postThread.iterator();
        LinkedList<PostThread> postOrder = new LinkedList<>();
        //if(model.asMap().get("sortMethod")=="score"){
        //    Collections.sort(postThread,score);
        //}
        //This boolean is just here as a placeholder so the site can be ran before we have everything set up.
        if(false){}
        else{
            while(iterator.hasNext()) {
                postOrder.push(iterator.next());
            }
            postThread.removeAll(postThread);
            while(!postOrder.isEmpty()){
                postThread.add(postOrder.pop());
            }
        }
        model.addAttribute("threads", postThread);
        model.addAttribute("category", "Questions and Answers");

        return "section";
    }

    @RequestMapping("/collab")
    public String getCollab (Model model) {
        List<PostThread> postThread = postThreadRepository.findByCategory("collab");
        Iterator<PostThread> iterator = postThread.iterator();
        LinkedList<PostThread> postOrder = new LinkedList<>();
        //if(model.asMap().get("sortMethod")=="score"){
        //    Collections.sort(postThread,score);
        //}
        //This boolean is just here as a placeholder so the site can be ran before we have everything set up.
        if(false){}
        else{
            while(iterator.hasNext()) {
                postOrder.push(iterator.next());
            }
            postThread.removeAll(postThread);
            while(!postOrder.isEmpty()){
                postThread.add(postOrder.pop());
            }
        }
        model.addAttribute("threads", postThread);
        model.addAttribute("category", "Collaboration Corner");

        return "section";
    }

    @RequestMapping("/news")
    public String getNews (Model model) {
        List<PostThread> postThread = postThreadRepository.findByCategory("news");
        Iterator<PostThread> iterator = postThread.iterator();
        LinkedList<PostThread> postOrder = new LinkedList<>();
        //if(model.asMap().get("sortMethod")=="score"){
        //    Collections.sort(postThread,score);
        //}
        //This boolean is just here as a placeholder so the site can be ran before we have everything set up.
        if(false){}
        else{
            while(iterator.hasNext()) {
                postOrder.push(iterator.next());
            }
            postThread.removeAll(postThread);
            while(!postOrder.isEmpty()){
                postThread.add(postOrder.pop());
            }
        }
        model.addAttribute("threads", postThread);
        model.addAttribute("category", "Tech News");

        return "section";
    }

    @RequestMapping("/jobs")
    public String getJobs (Model model) {
        List<PostThread> postThread = postThreadRepository.findByCategory("jobs");
        Iterator<PostThread> iterator = postThread.iterator();
        LinkedList<PostThread> postOrder = new LinkedList<>();
        //if(model.asMap().get("sortMethod")=="score"){
        //    Collections.sort(postThread,score);
        //}
        //This boolean is just here as a placeholder so the site can be ran before we have everything set up.
        if(false){}
        else{
            while(iterator.hasNext()) {
                postOrder.push(iterator.next());
            }
            postThread.removeAll(postThread);
            while(!postOrder.isEmpty()){
                postThread.add(postOrder.pop());
            }
        }
        model.addAttribute("threads", postThread);
        model.addAttribute("category", "Job Postings");

        return "section";
    }
}
