import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums={2,2,3,4};
        int res=triangleNumber(nums);
        System.out.println(1);
    }
    public static int triangleNumber(int[] nums) {
        if(nums.length<3){
            return 0;
        }
        int sum=0;
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=2;i--){
            int temp=nums[i];
            int left=0,right=i-1;
            while(left<right){
                if(nums[left]+nums[right]>temp){
                    sum+=(right-left);
                    right--;
                }else{
                    left++;
                }
            }
        }
        return sum;
    }
}
