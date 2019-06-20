public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public double findMaxAverage(int[] nums, int k) {
        int maxRes=Integer.MIN_VALUE;
        int start=0;
        for(int i=0;i<k;i++){
            start+=nums[i];
        }
        maxRes=Math.max(maxRes,start);
        for(int i=1;i<=nums.length-k;i++){
            start=start-nums[i-1]+nums[i+k-1];
            maxRes=Math.max(maxRes,start);
        }
        double res=(double)maxRes/k;
        return res;
    }
}
