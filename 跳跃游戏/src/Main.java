import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static boolean flag=false;

    public static void main(String[] args) {
        int[] nums={2,0,0};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        List<Boolean> flag=new ArrayList<Boolean>();
        flag.add(false);
        find(0,nums,flag);
        return flag.get(0)?true:false;
    }
    public static void find(int index,int[] nums,List<Boolean> flag){
        if(flag.get(0)||index>=nums.length-1){
            flag.set(0,true);
            return;
        }
        for(int i=1;i<=nums[index];i++){
            find(index+i,nums,flag);
        }
    }
}
