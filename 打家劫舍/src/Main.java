import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
    //动态规划
    public int rob(int[] nums) {
        int[] arr=new int[nums.length];
        arr[0]=nums[0];
        arr[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            arr[i]=Math.max(arr[i-2]+nums[i],arr[i-1]);
        }
        return arr[arr.length-1];
    }

    //回溯法通用解
    public int rob2(int[] nums){
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        List<Integer> allRes=new ArrayList<Integer>();
        allRes.add(0);
        int tempRes=0;
        getRes(nums,0,allRes,nums[0]);
        getRes(nums,1,allRes,nums[1]);
        return allRes.get(0);
    }
    public void getRes(int[] nums,int index,List<Integer> allRes,int tempRes){
        if(index>=nums.length-2){
            if(tempRes>allRes.get(0)){
                allRes.set(0,tempRes);
            }
            return;
        }
        for(int i=index+2;i<=Math.min(index+3,nums.length-1);i++){
            getRes(nums,i,allRes,tempRes+nums[i]);
        }
    }
}
