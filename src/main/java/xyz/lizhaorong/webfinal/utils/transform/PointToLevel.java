package xyz.lizhaorong.webfinal.utils.transform;

/**
 * 转换分数为等级
 */
public class PointToLevel {
    public static String cast(int point){
        if(10 >= point){
            return "斗师";
        }
        if(100 >= point){
            return "斗王";
        }
        if(500 >= point){
            return "斗宗";
        }
        if(2000 >= point){
            return "斗神";
        }
        return "斗师";
    }
}
