import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        String res=reverseWords("Let's take LeetCode contest");
        System.out.println(1);
    }
    public static String reverseWords(String s) {
        String[] ques=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(String tmp:ques){
            sb.append(new StringBuilder(tmp).reverse().toString());
            sb.append(" ");
        }
        return sb.toString().substring(0,sb.length()-1);
    }
}
