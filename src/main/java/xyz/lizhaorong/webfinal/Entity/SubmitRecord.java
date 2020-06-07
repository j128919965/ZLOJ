package xyz.lizhaorong.webfinal.Entity;

import java.time.LocalDateTime;

public class SubmitRecord {
    private int id;
    private int pid;
    private int uid;
    private LocalDateTime time;
    private byte state;
    private long used_time;
    private long used_space;


    @Override
    public String toString() {
        return "SubmitRecord{" +
                "id=" + id +
                ", pid=" + pid +
                ", uid=" + uid +
                ", time=" + time +
                ", state=" + state +
                ", used_time=" + used_time +
                ", used_space=" + used_space +
                '}';
    }

    public SubmitRecord(int id, int pid, int uid, LocalDateTime time, byte state, long used_time, long used_space) {
        this.id = id;
        this.pid = pid;
        this.uid = uid;
        this.time = time;
        this.state = state;
        this.used_time = used_time;
        this.used_space = used_space;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public long getUsed_time() {
        return used_time;
    }

    public void setUsed_time(long used_time) {
        this.used_time = used_time;
    }

    public long getUsed_space() {
        return used_space;
    }

    public void setUsed_space(long used_space) {
        this.used_space = used_space;
    }
}
