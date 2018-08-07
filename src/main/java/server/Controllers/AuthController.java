package server.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import server.models.User;
import server.repositories.UserRepository;

@Controller
@SessionAttributes("username")
@RequestMapping("/login")
public class AuthController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/register")
    public String getRegisterForm() {
        return "register";
    }

    @PostMapping
    public String createUser(
            @RequestParam String username,
            @RequestParam String password
    ) {
        User user = userRepository.save(new User(username, password));
        return "redirect:/forum";
    }

    @RequestMapping("/login")
    public String getLoginForm() {
        return "login";
    }

//    @GetMapping("/login")
//    public String login(
//            @RequestParam String username,
//            @RequestParam String password
//    ) {
//
//    }


}
