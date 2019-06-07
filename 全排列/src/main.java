import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    private static List<List<Integer>> ret;
    public static void main(String[] args) {
        int[] nums={1,2,3};
        permute(nums);
        System.out.println(1);
    }

    public static List<List<Integer>> permute(int[] nums) {
        ret=new ArrayList<List<Integer>>();
        int length=nums.length;
        boolean[] visit=new boolean[length];
        Arrays.fill(visit,false);
        List<Integer> tmpList=new ArrayList<Integer>();
        find(nums,visit,tmpList);
        return ret;
    }

    public static void find(int[] nums,boolean[] visit,List<Integer> tmpRes){
        if(tmpRes.size()==nums.length){
            List<Integer> resList=new ArrayList<Integer>();
            resList.addAll(tmpRes);
            ret.add(resList);
            return;
        }

        for(int i=0;i<visit.length;i++){
            if(!visit[i]){
                visit[i]=true;
                tmpRes.add(nums[i]);
                find(nums,visit,tmpRes);
                visit[i]=false;
                tmpRes.remove(tmpRes.size()-1);
            }
        }

    }
}
