package xyz.lizhaorong.webfinal.WebController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    @GetMapping
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/register")
    @GetMapping
    public String registerPage(){
        return "register";
    }

}
