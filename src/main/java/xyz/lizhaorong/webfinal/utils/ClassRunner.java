package xyz.lizhaorong.webfinal.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class ClassRunner {
    public void run(int proId,int userId,String code) throws CompileWrongException, RunningException {
        MyCompiler compiler = new MyCompiler(proId,userId, LocalDateTime.now());
        if(compiler.compile(code)!=0){
            throw new CompileWrongException();
        };

        DiskClassLoader loader = new DiskClassLoader(compiler.getClassPath());
        try {
            Class c = loader.loadClass("Main");
            if(c!=null){
                Object obj = c.newInstance();
                Method method = c.getDeclaredMethod("main",String[].class);
                method.invoke(null, (Object) new String[]{"123465"});
            }
        } catch (Exception e){
            throw new RunningException();
        }
    }

    public static void main(String[] args) {
        try {
            new ClassRunner().run(3,2,"class Solution{\n" +
                    "    public String addTwoNums(String a,String b){\n" +
                    "       return \"hello\";\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class Main{\n" +
                    "    public static void main(String[] args){\n" +
                    "        boolean x = true;" +
                    "        while(x){}ddd" +
                    "        Solution solution = new Solution();\n" +
                    "        System.out.println(solution.addTwoNums(\"A\",\"b\"));\n" +
                    "    }\n" +
                    "    \n" +
                    "}");
        } catch (CompileWrongException e) {
            System.out.println("编译错误");
        } catch (RunningException e) {
            System.out.println("运行时错误");
        }
    }
}
