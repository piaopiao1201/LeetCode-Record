import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            Integer temp=nums[i];
            if(!map.containsKey(temp)){
                map.put(nums[i],i);
            }else{
                int index=map.get(nums[i]);
                if(i-index<=k){
                    return true;
                }else{
                    map.put(nums[i],i);
                }
            }
        }
        return false;
    }
}
