import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        int res=lengthOfLongestSubstring("abcabcbb");
        System.out.println(res);
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        int maxLen=0;
        int start=0;
        for(int i=start;i<s.length();i++){
            Character temp=s.charAt(i);
            if(!map.containsKey(temp)||map.get(temp)==0){
                map.put(temp,1);
            }else{
                maxLen=Math.max(maxLen,i-start);
                for(int j=start;j<i;j++){
                    Character temp2=s.charAt(j);
                    if(temp2==temp){
                        map.put(temp2,1);
                        start=j+1;
                        break;
                    }else {
                        map.put(temp2, 0);
                    }
                }
//                start=i;
            }
//            if(map.containsKey(temp)&&map.get(temp)==1){
//                maxLen=Math.max(maxLen,i-start);
//                for(int j=start;j<i;j++){
//                    Character temp2=s.charAt(j);
//                    map.put(temp2,0);
//                }
//                start=i;
//
//            }else{
//                map.put(temp,1);
//            }
        }
        maxLen=Math.max(maxLen,s.length()-start);
        return maxLen;
    }
}
