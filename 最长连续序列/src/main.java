import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.Executors;

public class main {
    public static void main(String[] args) {
        int[] nums={1,2,0,1};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int last=nums[0];
        int maxLength=1;
        int nowLength=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==last){
                continue;
            }
            if(nums[i]==last+1){
                last=nums[i];
                nowLength++;
            }else{
                maxLength=Math.max(nowLength,maxLength);
                nowLength=1;
                last=nums[i];
            }
        }
        maxLength=Math.max(nowLength,maxLength);
        return maxLength;
    }
}
