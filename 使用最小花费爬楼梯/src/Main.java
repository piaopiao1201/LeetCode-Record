public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==2){
            return Math.min(cost[0],cost[1]);
        }
        if(cost.length==3){
            return Math.min(cost[0]+cost[2],cost[1]);
        }
        int[] dp=new int[cost.length];
        dp[0]=cost[0];
        dp[1]=cost[1];
        int minCost=Integer.MAX_VALUE;
        for(int i=2;i<cost.length;i++){
            dp[i]=Math.min(dp[i-2]+cost[i],dp[i-1]+cost[i]);
            if(i==cost.length-1||i==cost.length-2){
                minCost=Math.min(minCost,dp[i]);
            }
        }
        return minCost;
    }
}
