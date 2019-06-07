import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        int[] nums={-1,2,1,4};
        System.out.println(threeSumClosest(nums,1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int tmpTarget=target-nums[i];
            int j=i+1,k=nums.length-1;
            while(j<k){
                if(nums[j]+nums[k]==tmpTarget){
                    ans=0;
                    break;
                }else if(nums[j]+nums[k]>tmpTarget){
                    if(Math.abs(ans)<=Math.abs(tmpTarget-nums[j]-nums[k])){
                        ans=ans;
                    }else{
                        ans=tmpTarget-nums[j]-nums[k];
                    }
                    k--;
                }else{
                    if(Math.abs(ans)<=Math.abs(tmpTarget-nums[j]-nums[k])){
                        ans=ans;
                    }else{
                        ans=tmpTarget-nums[j]-nums[k];
                    }
                    j++;
                }
            }
        }
        return target-ans;
    }
}
