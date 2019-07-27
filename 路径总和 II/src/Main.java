import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> tempRes=new ArrayList<>();
        int nowSum=0;
        HasSum(root,nowSum,sum,res,tempRes);
        return res;
    }
    public void HasSum(TreeNode root,int sum,int goal,List<List<Integer>> res,List<Integer> tempRes){
        if(root==null){
            return;
        }
        tempRes.add(root.val);
        if(root.left==null&&root.right==null&&sum+root.val==goal){

            List<Integer> tmp=new ArrayList<>(tempRes);
            res.add(tmp);
        }

        HasSum(root.left,sum+root.val,goal,res,tempRes);
        HasSum(root.right,sum+root.val,goal,res,tempRes);
        tempRes.remove(tempRes.size()-1);
    }
}
