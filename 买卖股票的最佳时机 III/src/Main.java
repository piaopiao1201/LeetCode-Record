public class Main {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        //k=2,i=prices.length
        int maxSellTime=2;
        int[][][] dp=new int[prices.length][maxSellTime+1][2];
        //case base 初始化第一天的数据
        dp[0][0][0]=0;
        dp[0][0][1]=-prices[0];
        dp[0][1][0]=0;
        dp[0][1][1]=-prices[0];
        dp[0][2][0]=0;
        dp[0][2][1]=-prices[0];
        for(int i=1;i<prices.length;i++){
            for(int k=1;k<=maxSellTime;k++){
                dp[i][k][0]=Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
                dp[i][k][1]=Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
            }
        }
        return dp[prices.length-1][maxSellTime][0];
    }
}
