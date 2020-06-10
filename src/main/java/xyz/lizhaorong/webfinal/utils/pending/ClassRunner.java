package xyz.lizhaorong.webfinal.utils.pending;

import xyz.lizhaorong.webfinal.Entity.State;
import xyz.lizhaorong.webfinal.Entity.SubmitRecord;
import xyz.lizhaorong.webfinal.utils.exception.CompileWrongException;
import xyz.lizhaorong.webfinal.utils.exception.RunningException;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * 使用submit来判题，返回记录结果
 */
public class ClassRunner {
    /**
     * 判题
     * @param proId 题目id
     * @param userId 用户id
     * @param code 代码（包括判题代码）
     * @return record
     */
    public SubmitRecord run(int proId,int userId,String code){
        LocalDateTime time = LocalDateTime.now();
        SubmitRecord record = new SubmitRecord();
        record.setId(0);
        record.setPid(proId);
        record.setUid(userId);
        record.setTime(time);
        record.setState(State.ACCEPT);

        /*
         * 编译阶段
         */
        MyCompiler compiler = new MyCompiler(proId,userId,time );
        try {
            if(compiler.compile(code)!=0){
                record.setState(State.COMPILE_WRONG);
                return record;
            }
        } catch (CompileWrongException e) {
            record.setState(State.COMPILE_WRONG);
            return record;
        }

        //运行
        long start , end;
        DiskClassLoader loader = new DiskClassLoader(compiler.getClassPath());
        try {
            Class c = loader.loadClass("Main");
            if(c!=null){
                Object obj = c.newInstance();
                Method method = c.getDeclaredMethod("run");
                start = System.currentTimeMillis();
                int s = (Integer) method.invoke(null,  null);
                if(s!=0)record.setState(State.WRONG_ANSWER);
                end = System.currentTimeMillis();
                record.setUsed_time(end-start);
            }
        } catch (Exception e){
            e.printStackTrace();
            record.setState(State.RUNTIME_ERROR);
            record.setUsed_time(-1);
        }
        record.setUsed_space(48400);
        return record;
    }
}
