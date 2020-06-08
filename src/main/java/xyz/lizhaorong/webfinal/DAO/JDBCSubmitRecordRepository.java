package xyz.lizhaorong.webfinal.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import xyz.lizhaorong.webfinal.Entity.SubmitRecord;

import java.io.*;
import java.util.Arrays;
import java.util.List;

@Repository
public class JDBCSubmitRecordRepository implements SubmitRecordRepository{

    private JdbcTemplate template;

    @Autowired
    public JDBCSubmitRecordRepository(JdbcTemplate template){
        this.template = template;
    }

    @Override
    public String getLastSubmit(int pid,int uid) {
        StringBuilder sb = new StringBuilder();
        File f = new File("D:\\mywebfinal\\sources\\"+pid+"\\"+uid);
        File[] fs = f.listFiles();
        assert fs != null;
        if(fs.length==0)return null;
        fs = fs[fs.length-1].listFiles();
        assert fs != null;
        f = fs[0];
        try(BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String buff;
            while ((buff=reader.readLine())!=null){
                sb.append(buff).append('\n');
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveSubmitRecord(SubmitRecord record) {

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
    public SubmitRecord getRecord(int uid, int pid) {
        return null;
    }

}
