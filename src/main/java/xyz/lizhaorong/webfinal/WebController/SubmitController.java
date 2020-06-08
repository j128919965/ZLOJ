package xyz.lizhaorong.webfinal.WebController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.lizhaorong.webfinal.DAO.ProblemRepository;
import xyz.lizhaorong.webfinal.DAO.SubmitRecordRepository;
import xyz.lizhaorong.webfinal.Entity.State;
import xyz.lizhaorong.webfinal.Entity.Submit;
import xyz.lizhaorong.webfinal.Entity.SubmitRecord;
import xyz.lizhaorong.webfinal.utils.pending.ClassRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/submit")
@ResponseBody
public class SubmitController {

    private ProblemRepository problemRepository;
    private SubmitRecordRepository submitRecordRepository;

    public SubmitController(ProblemRepository problemRepository, SubmitRecordRepository submitRecordRepository) {
        this.problemRepository = problemRepository;
        this.submitRecordRepository = submitRecordRepository;
    }

    @PostMapping
    public boolean submit(@RequestBody Submit submit){

        String pending_code = problemRepository.getPendingCode(submit.getPid());
        String code = pending_code + submit.getCode();

        SubmitRecord record = new ClassRunner().run(submit.getPid(),submit.getUid(),code);

        System.out.println(record);
        submitRecordRepository.saveSubmitRecord(record);

        return true;
    }

    @GetMapping("/getRecord")
    public List<SubmitRecord> getSubmitRecord(int uid, int pid){
        return submitRecordRepository.getRecord(uid,pid);
    }
}
