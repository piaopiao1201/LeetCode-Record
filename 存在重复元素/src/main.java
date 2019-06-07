import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class main {
    public static void main(String[] args) {

    }
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> check=new LinkedHashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(check.contains(nums[i])){
                return true;
            }else{
                check.add(nums[i]);
            }
        }
        return false;
    }
}
