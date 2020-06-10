package xyz.lizhaorong.webfinal.DAO;

import xyz.lizhaorong.webfinal.Entity.SubmitRecord;

import java.util.List;


public interface SubmitRecordRepository {

    /**
     * 获取最后一次提交的代码
     * @param pid 题目id
     * @param uid 用户id
     * @return 代码
     */
    String getLastSubmit(int pid,int uid);

    /**
     * 保存提交记录
     * @param record 记录
     */
    void saveSubmitRecord(SubmitRecord record);

    /**
     * 获取提交记录
     * @param uid 用户id
     * @param pid 题目id
     * @return list of record
     */
    List<SubmitRecord> getRecord(int uid, int pid);

}
