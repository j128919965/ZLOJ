package xyz.lizhaorong.webfinal.DAO;

import xyz.lizhaorong.webfinal.Entity.SubmitRecord;

import java.util.List;

public interface SubmitRecordRepository {

    String getLastSubmit(int pid,int uid);

    void saveSubmitRecord(SubmitRecord record);

    SubmitRecord getRecordByUid(int uid);

    SubmitRecord getRecordByPid(int pid);

    List<SubmitRecord> getRecord(int uid, int pid);

}
