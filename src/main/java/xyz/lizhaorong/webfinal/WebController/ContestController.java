package xyz.lizhaorong.webfinal.WebController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ContestController {

    @RequestMapping("/contest")
    @GetMapping
    public String contestPage(){
        return "contest";
    }

    @RequestMapping("/contestDetail")
    @GetMapping
    public String contestDetail(){
        return "contest-detail";
    }

}
