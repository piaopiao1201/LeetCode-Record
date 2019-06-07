public class Main {
    public static void main(String[] args) {
        String res=longestPalindrome("cbbd");
        System.out.println(res);
    }
    public static String longestPalindrome(String s) {
        int[][] dp=new int[s.length()][s.length()];
        String res="";
        for(int i=0;i<s.length();i++){
            dp[i][i]=1;
            res=String.valueOf(s.charAt(i));
        }

        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=1;
                res=s.substring(i,i+2);
            }else{
                dp[i][i+1]=0;
            }
        }
        for(int i=3;i<=s.length();i++){
            for(int j=0;j<=s.length()-i;j++){
                int end=j+i-1;
                int begin=j;
                if(s.charAt(begin)==s.charAt(end)){
                    if(dp[begin+1][end-1]==1){
                        res=s.substring(begin,end+1);
                        dp[begin][end]=1;
                    }else{
                        dp[begin][end]=0;
                    }
                }else{
                    dp[begin][end]=0;
                }
            }
        }
        return res;
    }
}
