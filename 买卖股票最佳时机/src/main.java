public class main {
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int minPrev=Integer.MAX_VALUE;
        int maxRes=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i]==Math.min(minPrev,prices[i])){
                minPrev=prices[i];
            }else{
                maxRes=Math.max(prices[i]-minPrev,maxRes);
            }
        }
        if(maxRes==Integer.MIN_VALUE){
            return 0;
        }
        return maxRes;
    }
}
