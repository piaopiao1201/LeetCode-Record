import com.sun.deploy.util.ArrayUtil;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> res=findAnagrams("cbaebabacd","abc");
        System.out.println(1);
    }
    public static List<Integer> findAnagrams2(String s,String p){
        Map<Character,Integer> need=new HashMap<>();
        Map
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        String ques=stringSort(p);
        for(int i=0;i<=s.length()-p.length();i++){
            String temp=s.substring(i,i+p.length());
            String tmp=stringSort(temp);
            if(ques.equals(tmp)){
                res.add(i);
            }
        }
        return res;
    }
    public static String stringSort(String s){
        char[] sArr=s.toCharArray();
        Character[] cArr=new Character[sArr.length];

        for(int i=0;i<sArr.length;i++){
            cArr[i]=sArr[i];
        }

        Arrays.sort(cArr, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1.compareTo(o2);
            }
        });
        StringBuilder sb=new StringBuilder();
        for(char c:cArr){
            sb.append(c);
        }
        return sb.toString();
    }
}
