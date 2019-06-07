import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class main {
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t3.right=t5;
        ArrayList<Integer> res=PrintFromTopToBottom(t1);
        System.out.println(1);
    }
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        ArrayList<Integer> res=new ArrayList<Integer>();
        TreeNode temp=root;
        while(temp!=null||queue.peek()!=null){
            if(temp!=null){
                res.add(temp.val);
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
                temp=null;
            }else{
                temp=queue.poll();
            }
        }
        return res;
    }
}
