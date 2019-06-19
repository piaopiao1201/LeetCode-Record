import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int res1=nums[n-1]*nums[n-2]*nums[n-3];
        int res2=nums[0]*nums[1]*nums[2];
        int res3=nums[0]*nums[1]*nums[n-1];
        List<Integer> list=new ArrayList<Integer>();
        list.add(res1);
        list.add(res2);
        list.add(res3);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        return list.get(list.size()-1);
    }
}
