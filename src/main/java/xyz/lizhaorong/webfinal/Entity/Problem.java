package xyz.lizhaorong.webfinal.Entity;

public class Problem {
    private int id;
    private String name_en;
    private String name_zh;
    private int point;
    private int level;
    private String default_code;
    private String pending_code;
    private String description_en;
    private String description_zh;
    private String last_code;

    public String getLast_code() {
        return last_code;
    }

    public void setLast_code(String last_code) {
        this.last_code = last_code;
    }

    public String getDefault_code() {
        return default_code;
    }

    public void setDefault_code(String default_code) {
        this.default_code = default_code;
    }

    public String getPending_code() {
        return pending_code;
    }

    public void setPending_code(String pending_code) {
        this.pending_code = pending_code;
    }

    public String getDescription_en() {
        return description_en;
    }

    public void setDescription_en(String description_en) {
        this.description_en = description_en;
    }

    public String getDescription_zh() {
        return description_zh;
    }

    public void setDescription_zh(String description_zh) {
        this.description_zh = description_zh;
    }

    public static class SimpleProblemInfo{
        private int id;
        private String name_en;
        private String name_zh;
        private int point;
        private int level;

        public SimpleProblemInfo(int id, String name_en, String name_zh, int point, int level) {
            this.id = id;
            this.name_en = name_en;
            this.name_zh = name_zh;
            this.point = point;
            this.level = level;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName_zh() {
            return name_zh;
        }

        public void setName_zh(String name_zh) {
            this.name_zh = name_zh;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getName_zh() {
        return name_zh;
    }

    public void setName_zh(String name_zh) {
        this.name_zh = name_zh;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public SimpleProblemInfo getSimpleInfo(){
        return new SimpleProblemInfo(id, name_en, name_zh, point, level);
    }
}
