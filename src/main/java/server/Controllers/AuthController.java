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
@SessionAttributes({"username", "dupeuser", "wrongpass"})
public class AuthController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public String checkDetails(Model model,
            @RequestParam String username,
            @RequestParam String password,
            HttpServletRequest request
    ){
        HttpSession sesh = request.getSession();
        boolean wrongPass = false;

        for(User checkUser:userRepository.findAll()){
            if(checkUser.username.equals(username)){
                if(checkUser.checkPassword(password)){
                    model.addAttribute("username",username);
                    sesh.setAttribute("loggedin",true);
                    sesh.setAttribute("user", checkUser);
                    sesh.setAttribute("wrongpass", wrongPass);

                    return "redirect:/";
                } else if (checkUser.checkPassword(password) != true) {
                    wrongPass = true;
                    sesh.setAttribute("wrongpass", wrongPass);

                    return "redirect:/login";
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
        HttpSession sesh = request.getSession();
        boolean dupeuser = false;

        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
        for(User checkUser:userRepository.findAll()){
            if(checkUser.username.equals(username)){
                dupeuser = true;
                sesh.setAttribute("dupeuser", dupeuser);
              
                return "redirect:/register";
            }
        }

        sesh.setAttribute("dupeuser", dupeuser);
        User user = userRepository.save(new User(username, hashed, 0));

        sesh.setAttribute("loggedin",true);
        model.addAttribute("username", username);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterForm() {
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
