import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
    public boolean hasPathSum(TreeNode root, int sum) {
        int nowSum=0;
        List<Boolean> flag=new ArrayList<>();
        flag.add(false);
        HasSum(root,0,sum,flag);
        return flag.get(0);
    }
    public void HasSum(TreeNode root,int sum,int goal,List<Boolean> flag){
        if(flag.get(0)==true||root==null){
            return;
        }
        if(root.left==null&&root.right==null&&sum+root.val==goal){
            flag.set(0,true);
        }
        HasSum(root.left,sum+root.val,goal,flag);
        HasSum(root.right,sum+root.val,goal,flag);
    }
}
