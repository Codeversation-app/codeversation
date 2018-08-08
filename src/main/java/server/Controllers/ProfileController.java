package server.Controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import server.models.User;
import server.repositories.UserRepository;

import java.util.Iterator;
import java.util.List;

@Controller
@SessionAttributes("username")
public class ProfileController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/profile")
    public String forum() {
        return "profile";
    }

    @PostMapping("/profile/changepass")
    private String changePW(
            @RequestParam String newPW,
            Model model
    ){
        List fullRepo = userRepository.findAll();
        Iterator<User> accountFinder = fullRepo.iterator();
        Boolean found = false;
        Boolean endFound = false;
        User toBeChecked = accountFinder.next();
        User nextOne = null;
        while(toBeChecked != null && endFound == false){
            if(toBeChecked.username.equals(model.asMap().get("username"))){
                found = true;
                endFound = true;
            }
            if(accountFinder.hasNext()) {
                nextOne = accountFinder.next();
            }
            if(nextOne==null)
            {endFound=true;}
            else {
                toBeChecked = nextOne;
            }
        }
        if(found==false){
            return "profile";
        }
        toBeChecked.passhash = BCrypt.hashpw(newPW, BCrypt.gensalt(12));

        userRepository.save(toBeChecked);
        return "profile";
    }
}
