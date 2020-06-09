package xyz.lizhaorong.webfinal.WebController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.lizhaorong.webfinal.DAO.ProblemRepository;
import xyz.lizhaorong.webfinal.Entity.Problem;
import xyz.lizhaorong.webfinal.Entity.SimpleUserAnswerInfo;
import xyz.lizhaorong.webfinal.Entity.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProblemSetController {

    private ProblemRepository jdbc;

    public ProblemSetController(ProblemRepository jdbc) {
        this.jdbc = jdbc;
    }

    @GetMapping
    @RequestMapping("/problemSet")
    public String problems(){
        return "problemSet";
    }

    @GetMapping
    @RequestMapping("/solved_info")
    @ResponseBody
    public SimpleUserAnswerInfo getInfo(){
        SimpleUserAnswerInfo info = new SimpleUserAnswerInfo();
        info.setAll(100);
        info.setSolved(95);
        info.setEasy(40);
        info.setHard(5);
        info.setMedium(50);

        info.setId(1);
        info.setPointAndLevel(234);

        return info;
    }

    @GetMapping
    @ResponseBody
    @RequestMapping("/problemListByID")
    public List<Problem.SimpleProblemInfo> getProblemsByID(int from,int limit){
        return (List<Problem.SimpleProblemInfo>) jdbc.getSimpleProblemInfo(from,limit);
    }


}
