package xyz.lizhaorong.webfinal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main{
    public static int run() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("D:\\mywebfinal\\io\\1\\io.txt"));
        String sb;
        while((sb = in.readLine())!=null){
            String[] s = sb.split(" ");
            String nt = new Solution().addTwoNums(s[0],s[1]);
            String nc = in.readLine();
            if(!nc.equals(nt)){return -1;}
        }
        return 0;
    }
}


class Solution{
    String addTwoNums(String s1,String s2){
        return new BigInteger(s1).add(new BigInteger(s2)).toString();
    }
}