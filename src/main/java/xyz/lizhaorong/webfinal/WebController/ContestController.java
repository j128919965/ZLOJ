package xyz.lizhaorong.webfinal.WebController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContestController {

    /**
     * 返回contest页面
     * @return page
     */
    @RequestMapping("/contest")
    @GetMapping
    public String contestPage(){
        return "contest";
    }

    /**
     * 获取contestDetail页面
     * @return page
     */
    @RequestMapping("/contestDetail")
    @GetMapping
    public String contestDetail(){
        return "contest-detail";
    }

}
