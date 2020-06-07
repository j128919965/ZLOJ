package xyz.lizhaorong.webfinal.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import xyz.lizhaorong.webfinal.Entity.Problem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JDBCProblemRepository implements ProblemRepository{

    private JdbcTemplate template;

    @Autowired
    public JDBCProblemRepository(JdbcTemplate template){
        this.template = template;
    }

    @Override
    public List<Problem.SimpleProblemInfo> getSimpleProblemInfo(int start, int limit) {
        return template.query(
                "select id,name_en,name_zh,point,level from problem limit "+start+","+limit,
                this::mapToSimpleProblemInfo
        );
    }

    @Override
    public Problem findProblemByID(int id) {
        return template.queryForObject(
                "select * from problem where id=?",this::mapToProblem,id
        );
    }

    private Problem.SimpleProblemInfo mapToSimpleProblemInfo(ResultSet rs,int rowNum)throws SQLException{
        return new Problem.SimpleProblemInfo(
                rs.getInt("id"),
                rs.getString("name_en"),
                rs.getString("name_zh"),
                rs.getInt("point"),
                rs.getInt("level")
        );
    }

    private Problem mapToProblem(ResultSet rs,int rowNum) throws SQLException {
        Problem problem = new Problem();
        problem.setId(rs.getInt("id"));
        problem.setName_en(rs.getString("name_en"));
        problem.setName_zh(rs.getString("name_zh"));
        problem.setPoint(rs.getInt("point"));
        problem.setLevel(rs.getInt("level"));
        problem.setDefault_code(rs.getString("default_code"));
        problem.setDescription_en(rs.getString("description_en"));
        problem.setDescription_zh(rs.getString("description_zh"));
        return problem;
    }

    private String mapToPendingCode(ResultSet rs,int r) throws SQLException {
        return rs.getString("pending_code");
    }

    @Override
    public String getPendingCode(int id) {
        return template.queryForObject(
                "select pending_code from problem where id=?",
                this::mapToPendingCode,id
        );
    }
}
