package server.Controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import server.models.User;
import server.repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @RequestMapping("/logout")
    public String logout() {
        return "logout";
    }

}
