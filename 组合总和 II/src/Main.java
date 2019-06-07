import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] candidates={10,1,2,7,6,1,5};
        int target=8;
        List<List<Integer>> res=combinationSum2(candidates,target);
        System.out.println(1);
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        boolean[] flag=new boolean[candidates.length];
        Arrays.fill(flag,false);
        List<Integer> tmpRes=new ArrayList<Integer>();
        find(candidates,flag,0,target,0,tmpRes,res);
        return res;
    }
    public static void find(int[] candidates,boolean[] flag,int index,int target,int sum,List<Integer> tmpRes,List<List<Integer>> allRes){
        if(sum==target){
            List<Integer> tmp=new ArrayList<Integer>(tmpRes);
            if(!allRes.contains(tmp)){
                allRes.add(tmp);
            }

            return;
        }
        if(sum>target){
            return;
        }
        for(int i=index;i<candidates.length;i++){
            tmpRes.add(candidates[i]);
            find(candidates,flag,i+1,target,sum+candidates[i],tmpRes,allRes);
            tmpRes.remove(tmpRes.size()-1);
        }
    }
}
