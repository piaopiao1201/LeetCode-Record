import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<Integer>();
        for(int i:nums1){
            set.add(i);
        }
        Set<Integer> set2=new HashSet<Integer>();
        for(int i:nums2){
            if(set.contains(i)){
                set2.add(i);
            }
        }
        int[] res=new int[set2.size()];
        int start=0;
        for(int i:set2){
            res[start++]=i;
        }
        return res;
    }
}
