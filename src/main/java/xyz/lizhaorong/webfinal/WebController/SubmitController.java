package xyz.lizhaorong.webfinal.WebController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.lizhaorong.webfinal.DAO.ProblemRepository;
import xyz.lizhaorong.webfinal.DAO.SubmitRecordRepository;
import xyz.lizhaorong.webfinal.Entity.Submit;
import xyz.lizhaorong.webfinal.Entity.SubmitRecord;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/submit")
@ResponseBody
public class SubmitController {

    private ProblemRepository problemRepository;
    private SubmitRecordRepository submitRecordRepository;

    public SubmitController(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    @PostMapping
    public boolean submit(@RequestBody Submit submit){

        System.out.println(submit);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return true;
    }

    @GetMapping("/getRecord")
    public List getSubmitRecord(int uid,int pid){
        List<SubmitRecord> list = new ArrayList<>();
        list.add(new SubmitRecord(uid,pid,2, LocalDateTime.now(), (byte) 1,234,39050));
        return list;
    }
}
