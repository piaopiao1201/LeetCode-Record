import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(3);
        TreeNode t2=new TreeNode(9);
        TreeNode t3=new TreeNode(20);
        TreeNode t4=new TreeNode(15);
        TreeNode t5=new TreeNode(7);
        t1.left=t2;
        t1.right=t3;
        t3.left=t4;
        t3.right=t5;
        List<List<Integer>> res=levelOrder(t1);
        System.out.println(1);
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<TreeNode>();
        Queue<Integer> queLayer=new LinkedList<Integer>();
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null){
            return res;
        }
        que.add(root);
        int startLayer=1;
        queLayer.add(startLayer);
        List<Integer> list=new ArrayList<Integer>();
        while(que.peek()!=null){
            TreeNode temp=que.poll();
            int layer=queLayer.poll();
            if(layer==startLayer){
                list.add(temp.val);
            }else{
                List<Integer> tempList=new ArrayList<Integer>(list);
                res.add(tempList);
                list.clear();
                list.add(temp.val);
                startLayer=layer;
            }
            if(temp.left!=null){
                que.add(temp.left);
                queLayer.add(layer+1);
            }
            if(temp.right!=null){
                que.add(temp.right);
                queLayer.add(layer+1);
            }
        }
        List<Integer> tempList=new ArrayList<Integer>(list);
        res.add(tempList);
        return res;
    }
}
