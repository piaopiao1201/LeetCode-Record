import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3){
            return false;
        }
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        dp[0]=-1;
        for(int i=1;i<nums.length;i++){
            int j=i-1;
            for(;j>=0;j--){
                if(nums[j]<nums[i]){
                    dp[i]=1;
                    if(dp[j]!=-1){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
