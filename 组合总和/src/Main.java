import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] candidates={2,3,5};
        int target=8;
        List<List<Integer>> res=combinationSum(candidates,target);
        System.out.println(1);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        find(candidates, target, temp, 0, res,0);
        return res;
    }
    public static void find(int[] candidates,int target,List<Integer> temp,int tempSum,List<List<Integer>> res,int startIndex){
        if(tempSum==target){
            List<Integer> tempRes=new ArrayList<Integer>(temp);
            res.add(tempRes);
            return;
        }
        if(tempSum>target){
            return;
        }
        for(int i=startIndex;i<candidates.length;i++){
            temp.add(candidates[i]);
            find(candidates,target,temp,tempSum+candidates[i],res,i);
            temp.remove(temp.size()-1);
        }
    }
}
