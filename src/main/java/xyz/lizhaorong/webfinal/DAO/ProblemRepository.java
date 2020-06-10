package xyz.lizhaorong.webfinal.DAO;

import xyz.lizhaorong.webfinal.Entity.Problem;

public interface ProblemRepository {

    /**
     * 获取题目简易信息列表
     * @param start 开始的id
     * @param limit 每页数量
     * @return 题目简易信息的list
     */
    Iterable<Problem.SimpleProblemInfo> getSimpleProblemInfo(int start, int limit);

    /**
     * 获取一道题的全部信息
     * @param id 题目id
     * @return 题目信息
     */
    Problem findProblemByID(int id);

    /**
     * 获取判题代码
     * @param id 题目id
     * @return 判题代码
     */
    String getPendingCode(int id);

}
