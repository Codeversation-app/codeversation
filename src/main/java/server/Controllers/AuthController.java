package server.Controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import server.models.User;
import server.repositories.UserRepository;

@Controller
@RequestMapping("/login")
@SessionAttributes("username")
public class AuthController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/register")
    public String getRegisterForm() {
        return "register";
    }

    @PostMapping
    public String createUser(
            Model model,
            @RequestParam String username,
            @RequestParam String password
    ) {
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
        User user = userRepository.save(new User(username, hashed));
        System.out.println("username: " + username);
        System.out.println("hashed password: " + hashed);

        model.addAttribute("username", username);

        return "redirect:/forum";
    }

    @RequestMapping
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
