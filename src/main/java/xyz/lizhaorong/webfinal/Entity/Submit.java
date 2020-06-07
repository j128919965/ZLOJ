package xyz.lizhaorong.webfinal.Entity;

public class Submit {

    private int pid;
    private int uid;
    private String code;

    @Override
    public String toString() {
        return "Submit{" +
                "pid=" + pid +
                ", uid=" + uid +
                ", code='" + code + '\'' +
                '}';
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
