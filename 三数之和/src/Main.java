import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res=new LinkedHashSet<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int sum=0-nums[i];
            int left=i+1,right=nums.length-1;
            while(left<right){
                if(nums[left]+nums[right]==sum){
                    Integer[] temp={nums[i],nums[left],nums[right]};
                    res.add(Arrays.asList(temp));
                    left++;
                }else if(nums[left]+nums[right]>sum){
                    right--;
                }else{
                    left++;
                }
            }
        }
        List<List<Integer>> allRes=new ArrayList<List<Integer>>();
        allRes.addAll(res);
        return allRes;
    }
}
