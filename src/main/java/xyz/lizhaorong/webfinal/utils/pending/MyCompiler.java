package xyz.lizhaorong.webfinal.utils.pending;

import xyz.lizhaorong.webfinal.utils.exception.CompileWrongException;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyCompiler {
    private int proId;
    private int userId;
    private LocalDateTime time;
    private String classPath;
    private String sourcePath;

    public String getClassPath() {
        return classPath;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public MyCompiler(int proId, int userId, LocalDateTime time){
        this.time = time;
        this.proId = proId;
        this.userId = userId;
        classPath = "D://mywebfinal//classes//"+proId+"//"+userId+"//"
                +time.format(DateTimeFormatter
                .ofPattern("yyyy-MM-dd-HH-mm-ss"));

//        classPath = "//home//mywebfinal//classes//"+proId+"//"+userId+"//"
//                +time.format(DateTimeFormatter
//                .ofPattern("yyyy-MM-dd-HH-mm-ss"));

        sourcePath = "D://mywebfinal//sources//"+proId+"//"+userId+"//"
                +time.format(DateTimeFormatter
                .ofPattern("yyyy-MM-dd-HH-mm-ss")
        )+"//Main.java";

//        sourcePath = "//home//mywebfinal//sources//"+proId+"//"+userId+"//"
//                +time.format(DateTimeFormatter
//                .ofPattern("yyyy-MM-dd-HH-mm-ss")
//        )+"//Main.java";
        System.out.println(sourcePath);
    }

    /**
     *
     * @param s
     * @return 0:正常
     *          1：编译错误
     *          2：
     */
    public int compile(String s) throws CompileWrongException {
        try{
            File file = new File(sourcePath);
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(s);
            writer.flush();
        }catch (IOException exception){
            return 2;
        }


        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        try{
            int status = javac.run(null,null,null,"-d",classPath,sourcePath);
            if(status!=0)return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
}
