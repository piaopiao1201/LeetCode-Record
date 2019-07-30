import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
    public TreeNode convertBST(TreeNode root) {
        List<TreeNode> res=new ArrayList<>();
        inOrder(root,res);
        for(int i=res.size()-2;i>=0;i--){
            res.get(i).val+=res.get(i+1).val;
        }
        return root;
    }
    public void inOrder(TreeNode root,List<TreeNode> res){
        if(root==null){
            return;
        }
        inOrder(root.left,res);
        res.add(root);
        inOrder(root.right,res);
    }
}
