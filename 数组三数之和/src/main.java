import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class main {
    public static void main(String[] args) {
        HashSet<List<Integer>> hashSet=new HashSet<List<Integer>>();
        int[] arr={0,0,0};
        List<List<Integer>> ret=threeSum(arr);
        for(List<Integer> list:ret){
            for(Integer i:list){
                System.out.print(i+",");
            }
            System.out.println();
        }
//        List<Integer> list=new ArrayList<Integer>(Arrays.asList(arr));
    }
//    public static List<List<Integer>> threeSum(int[] nums) {
//        HashSet<List<Integer>> ret = new HashSet<List<Integer>>();
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 2; i++) {
//            if (nums[i] > 0) {
//                break;
//            }
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                    }
//                }
//            }
//        }
//        List<List<Integer>> ret2 = new ArrayList<List<Integer>>();
//        for (List<Integer> list : ret) {
//            ret2.add(list);
//        }
//        return ret2;
//
//    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3){
            List<List<Integer>> ret=new ArrayList<List<Integer>>();
            return ret;
        }
        HashSet<List<Integer>> ret = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;nums[i]<=0&&i<nums.length-2;i++) {
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int target = 0 - nums[i];
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                } else if (nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        List<List<Integer>> ret2 = new ArrayList<List<Integer>>();
        for (List<Integer> list : ret) {
            ret2.add(list);
        }
        return ret2;
    }
}
