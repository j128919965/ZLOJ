package xyz.lizhaorong.webfinal.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import xyz.lizhaorong.webfinal.Entity.State;
import xyz.lizhaorong.webfinal.Entity.SubmitRecord;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

@Repository
public class JDBCSubmitRecordRepository implements SubmitRecordRepository{

    private final JdbcTemplate template;

    @Autowired
    public JDBCSubmitRecordRepository(JdbcTemplate template){
        this.template = template;
    }

    @Override
    public String getLastSubmit(int pid,int uid) {
        StringBuilder sb = new StringBuilder();
//        File f = new File("\\home\\mywebfinal\\sources\\"+pid+"\\"+uid);
        File f = new File("D:\\mywebfinal\\sources\\"+pid+"\\"+uid);
        if(!f.exists())f.mkdirs();
        File[] fs = f.listFiles();
        if(fs==null||fs.length==0){
            return null;
        }
        fs = fs[fs.length-1].listFiles();
        assert fs != null;
        f = fs[0];
        try(BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String buff;
            while ((buff=reader.readLine())!=null){
                sb.append(buff).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int index = sb.lastIndexOf("class Solution");
        return sb.substring(index);
    }

    @Override
    public void saveSubmitRecord(SubmitRecord record) {
        template.update(
                "insert into submitrecord (`pid`,`uid`,`time`,`state`,`used_time`,`used_space`) values (?,?,?,?,?,?)"
                ,record.getPid(),record.getUid(),
                Timestamp.valueOf(record.getTime()),record.getState().toByteCode(),
                record.getUsed_time(),record.getUsed_space()
        );
    }

    @Override
    public SubmitRecord getRecordByUid(int uid) {
        return null;
    }

    @Override
    public SubmitRecord getRecordByPid(int pid) {
        return null;
    }

    @Override
    public List<SubmitRecord> getRecord(int uid, int pid) {
        return template.query(
                "select `time`,state,used_time,used_space from submitrecord where pid=? and uid=?",
                this::mapToRecord,pid,uid
        );

    }

    private SubmitRecord mapToRecord(ResultSet rs,int r) throws SQLException {
        SubmitRecord record = new SubmitRecord();
        record.setUsed_space(rs.getLong("used_space"));
        record.setUsed_time(rs.getLong("used_time"));
        record.setState(State.getState(rs.getByte("state")));
        record.setTime(rs.getTimestamp("time").toLocalDateTime());
        return record;
    }

}
