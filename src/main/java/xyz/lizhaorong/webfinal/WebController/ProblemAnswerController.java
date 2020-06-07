package xyz.lizhaorong.webfinal.WebController;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.lizhaorong.webfinal.DAO.ProblemRepository;
import xyz.lizhaorong.webfinal.Entity.Problem;
import xyz.lizhaorong.webfinal.Entity.User;

@Controller
@RequestMapping
public class ProblemAnswerController {

    private ProblemRepository repository;

    public ProblemAnswerController(ProblemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/problems/{pro_id}")
    public String problemAnswerPage(@PathVariable("pro_id") int id, Model model){

        Problem problem = repository.findProblemByID(id);
        problem.setLast_code("nc?");

        Object o = JSONObject.toJSON(problem);
        model.addAttribute("ss",o);
        return "problem";
    }

}