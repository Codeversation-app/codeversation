package server.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/new-post")
public class PostController {
    @RequestMapping("/form")
    public String getPostForm(){
        return "new-post";
    }


}