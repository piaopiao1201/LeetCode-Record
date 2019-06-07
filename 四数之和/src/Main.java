import com.sun.javafx.collections.MappingChange;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> res=new LinkedHashSet<List<Integer>>();
        Arrays.sort(nums);
        for(int j=0;j<nums.length-3;j++){
            int sum=target-nums[j];
            for(int i=j+1;i<nums.length-2;i++){
                int sum2=sum-nums[i];
                int left=i+1,right=nums.length-1;
                while(left<right){
                    if(nums[left]+nums[right]==sum2){
                        Integer[] temp={nums[j],nums[i],nums[left],nums[right]};
                        res.add(Arrays.asList(temp));
                        left++;
                    }else if(nums[left]+nums[right]>sum2){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        List<List<Integer>> allRes=new ArrayList<List<Integer>>();
        allRes.addAll(res);
        return allRes;
    }
}
