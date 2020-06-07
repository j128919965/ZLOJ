package xyz.lizhaorong.webfinal.DAO;

import xyz.lizhaorong.webfinal.Entity.Problem;

public interface ProblemRepository {

    Iterable<Problem.SimpleProblemInfo> getSimpleProblemInfo(int start, int limit);

    Problem findProblemByID(int id);

    String getPendingCode(int id);

}
