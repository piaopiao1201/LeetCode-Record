import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s="aaaaaaa";
        List<String> wordDict=new ArrayList<String>();
        wordDict.add("aaaa");
        wordDict.add("aaa");
        boolean res=wordBreak(s,wordDict);
        System.out.println(res);
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        int[] dp=new int[s.length()];
        for(int i=0;i<s.length();i++){
            int j;
            for(j=i;j>=0;j--){
                if(dp[j]==1){
                    if(wordDict.contains(s.substring(j+1,i+1))){
                        dp[i]=1;
                    }
                }
            }
            if(j==-1){
                if(wordDict.contains(s.substring(0,i+1))){
                    dp[i]=1;
                }
                continue;
            }

        }
        return dp[s.length()-1]==1?true:false;
    }
}
