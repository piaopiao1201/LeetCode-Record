import org.omg.CORBA.StringHolder;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int res=titleToNumber("ZY");
        String s=".sasa.sasa";
        String[] str=s.split("");
        System.out.println(1);
    }
    public static int titleToNumber(String s) {
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        for(char i='A';i<='Z';i++){
            map.put(i,1+(i-'A'));
        }
        int res=0;
        for(int i=0;i<s.length();i++){
            res+=Math.pow(26,s.length()-1-i)*map.get(s.charAt(i));
        }
        return res;
    }
}
