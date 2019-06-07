import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class main {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<Integer> queue=new LinkedList<Integer>();
        Queue<TreeNode> queue2=new LinkedList<TreeNode>();
        queue2.add(root);
        int maxLength=0;
        int curLength=1;
        queue.add(curLength);
        while(!queue2.isEmpty()){
            TreeNode tmp=queue2.remove();
            Integer length=queue.remove();
            maxLength=Math.max(maxLength,length);
            if(tmp.left!=null){
                queue2.add(tmp.left);
                queue.add(length+1);
            }
            if(tmp.right!=null){
                queue2.add(tmp.right);
                queue.add(length+1);
            }
        }
        return maxLength;
    }
}
