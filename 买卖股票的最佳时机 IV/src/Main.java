public class Main {
    public static void main(String[] args) {

    }
    public int maxProfit(int k, int[] prices) {
        if(prices.length==0){
            return 0;
        }
        //k=2,i=prices.length
        if(k >= prices.length/2) return greedy(prices);
        int maxSellTime=k;
        int[][][] dp=new int[prices.length][maxSellTime+1][2];
        //case base
        for(int i=0;i<=maxSellTime;i++){
            dp[0][i][0]=0;
            dp[0][i][1]=-prices[0];
        }
        for(int i=1;i<prices.length;i++){
            for(int j=1;j<=maxSellTime;j++){
                dp[i][j][0]=Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
            }
        }
        return dp[prices.length-1][maxSellTime][0];
    }
    public int greedy(int[] prices) {
        int max = 0;
        for(int i = 1; i < prices.length; ++i) {
            if(prices[i] > prices[i-1])
                max += prices[i] - prices[i-1];
        }
        return max;
    }
}
