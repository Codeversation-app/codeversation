package server.Controllers;

import org.hibernate.Session;
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
@SessionAttributes("username")
public class AuthController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public String checkDetails(Model model,
            @RequestParam String username,
            @RequestParam String password,
            HttpServletRequest request
    ){
        for(User checkUser:userRepository.findAll()){
            if(checkUser.username.equals(username)){
                if(checkUser.checkPassword(password)){
                    model.addAttribute("username",username);
                    HttpSession sesh = request.getSession();
                    sesh.setAttribute("loggedin",true);
                    sesh.setAttribute("user", checkUser);
                    return "redirect:/";
                }
            }
        }
        return "redirect:/register";
    }

    @PostMapping("/register")
    public String createUser(
            Model model,
            @RequestParam String username,
            @RequestParam String password,
            HttpServletRequest request
    ) {
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
        for(User checkUser:userRepository.findAll()){
            if(checkUser.username.equals(username)){
                String duplicateUserMessage = "Username already taken. Please try again.";
                model.addAttribute("duplicateusermessage", duplicateUserMessage);
                return "redirect:/register";
            }
        }

        User user = userRepository.save(new User(username, hashed, 0));

        HttpSession sesh = request.getSession();
        sesh.setAttribute("loggedin",true);
        model.addAttribute("username", username);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterForm(
    ) {
        return "register";
    }

//    @GetMapping("/login")
//    public String login(
//            @RequestParam String username,
//            @RequestParam String password
//    ) {
//
//    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("loggedin", false);
        model.addAttribute("username", "");
        return "login";

    }

}
