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

    /**
     * 判题
     * @param submit pid，uid，code
     * @return true 判题结束
     */
    @PostMapping
    public boolean submit(@RequestBody Submit submit){

        String pending_code = problemRepository.getPendingCode(submit.getPid());
        String code = pending_code + submit.getCode();

        /*
         * 判题并返回结果
         */
        SubmitRecord record = new ClassRunner().run(submit.getPid(),submit.getUid(),code);

        //保存数据
        submitRecordRepository.saveSubmitRecord(record);

        return true;
    }

    /**
     * 获取判题记录列表
     * @param uid 用户id
     * @param pid 题目id
     * @return list
     */
    @GetMapping("/getRecord")
    public List<SubmitRecord> getSubmitRecord(int uid, int pid){
        return submitRecordRepository.getRecord(uid,pid);
    }
}
