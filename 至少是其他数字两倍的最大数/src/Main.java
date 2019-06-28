import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public int dominantIndex(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int maxInterger=0;
        int maxNum=Integer.MIN_VALUE;
        int maxIndex=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>maxNum){
                maxNum=nums[i];
                maxIndex=i;
            }
        }
        Arrays.sort(nums);
        if(nums[nums.length-2]==0){
            return maxIndex;
        }
        return nums[nums.length-1]/nums[nums.length-2]<2?-1:maxIndex;
    }
}
