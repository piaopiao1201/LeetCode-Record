import java.util.ArrayList;
import java.util.List;

public class Main {
    public void flatten(TreeNode root) {
        List<TreeNode> res=new ArrayList<>();
        preOrder(root,res);
        for(int i=0;i<res.size();i++){
            if(i<res.size()-1){
                res.get(i).left=null;
                res.get(i).right=res.get(i+1);
            }else{
                res.get(i).left=null;
                res.get(i).right=null;
            }

        }
    }
    public void preOrder(TreeNode root,List<TreeNode> res){
        if(root==null){
            return;
        }
        res.add(root);
        preOrder(root.left,res);
        preOrder(root.right,res);
    }
}
