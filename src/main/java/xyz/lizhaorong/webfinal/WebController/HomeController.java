package xyz.lizhaorong.webfinal.WebController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    /**
     * 获取根目录页面
     * @return page
     */
    @GetMapping
    @RequestMapping("/")
    public String home(){
        return "index";
    }
}
