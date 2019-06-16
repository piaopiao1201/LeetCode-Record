import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Integer> map=new TreeSet<Integer>();
        map.add(2);
        map.add(5);
        map.add(4);
        System.out.println(1);
    }
    public int findPairs(int[] nums, int k) {
        if(k<0){
            return 0;
        }
        Set<Integer> set=new TreeSet<Integer>();
        Set<Integer> mult=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                mult.add(nums[i]);
            }
            set.add(nums[i]);
        }
        if(k==0){
            return mult.size();
        }
        int sum=0;
        for(Integer i:set){
            if(set.contains(i+k)){
                sum++;
            }
        }
        return sum;
    }
}
