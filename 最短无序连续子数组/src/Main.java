import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums={2, 6, 4, 8, 10, 9, 15};
        int res=findUnsortedSubarray(nums);
        System.out.println(1);
    }
    public static int findUnsortedSubarray(int[] nums) {
        int[] nums2=Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums2);
        int start=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=nums2[i]){
                start=i;
                break;
            }
        }
        int end=0;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]!=nums2[i]){
                end=i;
                break;
            }
        }
        if(start==end){
            return 0;
        }
        return end-start+1;
    }
}
