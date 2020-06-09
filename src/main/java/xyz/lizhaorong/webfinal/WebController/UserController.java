package xyz.lizhaorong.webfinal.WebController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userCenter")
public class UserController {

    @GetMapping
    public String userCenterPage(){
        return "user_center";
    }

}
