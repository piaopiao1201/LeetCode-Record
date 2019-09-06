import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int res=longestSubstring("ababacb",3);
        System.out.println(1);
    }
    public static int longestSubstring(String s, int k) {
        if(s.length()<k){
            return 0;
        }
        return count(s.toCharArray(),0,s.length()-1,k);
    }
    public static int count(char[] strArr,int start,int end,int k){
        if(end-start+1<k){
            return 0;
        }
        //先统计所有字符出现的次数
        Map<Character, Integer> map=new HashMap<>();
        for(int i=start;i<=end;i++){
            if(map.containsKey(strArr[i])){
                map.put(strArr[i],map.get(strArr[i])+1);
            }else{
                map.put(strArr[i],1);
            }
        }
        int p1=start,p2=end;
        while(p1<=p2&&p2-p1+1>=k){
            if(map.get(strArr[p1])<k){
                p1++;
            }else {
                break;
            }
        }
        while(p1<=p2&&p2-p1+1>=k){
            if(map.get(strArr[p2])<k){
                p2--;
            }else {
                break;
            }
        }
        for(int i=p1;i<=p2;i++){
            if(map.get(strArr[i])<k){
                return Math.max(count(strArr,p1,i-1,k),count(strArr,i+1,p2,k));
            }
        }
        return p2-p1+1;
    }
}
