package xyz.lizhaorong.webfinal.Entity;

import xyz.lizhaorong.webfinal.utils.PointToLevel;

public class SimpleUserAnswerInfo {
    //总题目数量
    private int all;
    //当前解决了的数量
    private int solved;

    private int easy;
    private int medium;
    private int hard;

    private int id;
    private String level;
    private int point;

    public void setPointAndLevel(int point){
        this.point = point;
        this.level = PointToLevel.cast(point);
    }


    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    public int getSolved() {
        return solved;
    }

    public void setSolved(int solved) {
        this.solved = solved;
    }

    public int getEasy() {
        return easy;
    }

    public void setEasy(int easy) {
        this.easy = easy;
    }

    public int getMedium() {
        return medium;
    }

    public void setMedium(int medium) {
        this.medium = medium;
    }

    public int getHard() {
        return hard;
    }

    public void setHard(int hard) {
        this.hard = hard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
