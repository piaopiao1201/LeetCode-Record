import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    private static List<List<Integer>> ret;
    public static void main(String[] args) {
        int[] nums={1,2,3};
        subsets(nums);
//        List<Integer> list1=new ArrayList<Integer>();
//        list1.add(1);
//        list1.add(2);
//        List<Integer> list2=new ArrayList<Integer>();
//        list2.add(2);
//        list2.add(1);
        System.out.println(1);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        ret=new ArrayList<List<Integer>>();
        boolean[] visit=new boolean[nums.length];
        Arrays.fill(visit,false);
        List<Integer> tmpRes=new ArrayList<Integer>();
        find(nums,visit,tmpRes,0);
        return ret;
    }

    public static void find(int[] nums,boolean[] visit,List<Integer> tmpRes,int sIndex){
        List<Integer> tmp=new ArrayList<Integer>();
        tmp.addAll(tmpRes);
        ret.add(tmp);

        for(int i=sIndex;i<visit.length;i++){
            if(!visit[i]){
                visit[i]=true;
                tmpRes.add(nums[i]);
                find(nums,visit,tmpRes,i);
                visit[i]=false;
                tmpRes.remove(tmpRes.size()-1);
            }
        }
    }
}
