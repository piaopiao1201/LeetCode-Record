import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            int act=Math.abs(nums[i]);
            if(nums[act]<0){
                res.add(act);
            }else{
                nums[act]*=-1;
            }
        }
        return res;
    }
}
